package io.github.junbaor.jike.api

import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.github.junbaor.jike.client.JikeClient
import io.github.junbaor.jike.common.Constants
import io.github.junbaor.jike.common.Constants.DEVICE_ID
import io.github.junbaor.jike.common.Constants.JIKE_HOST
import io.github.junbaor.jike.common.Constants.REFRESH_TOKEN_URL
import io.github.junbaor.jike.exception.NoLoginException
import io.github.junbaor.jike.model.Token
import com.moczul.ok2curl.CurlInterceptor
import feign.Feign
import feign.Retryer
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.time.Duration
import java.util.*

class JikeApiFactory {

  companion object {
    fun create(jike: JikeClient): JikeApi {
      val loggingInterceptor = HttpLoggingInterceptor { msg ->
        println(msg)
      }.setLevel(HttpLoggingInterceptor.Level.BODY)

      val curlLogInterceptor = CurlInterceptor { msg -> println(msg) }

      val okHttpClient = OkHttpClient.Builder()
        .readTimeout(Duration.ofSeconds(5))
        .connectTimeout(Duration.ofSeconds(5))
        .addNetworkInterceptor(loggingInterceptor)
        .addNetworkInterceptor(curlLogInterceptor)
        .addInterceptor(Interceptor { chain: Interceptor.Chain ->
          val request = chain.request().newBuilder()

          // 通用请求头
          defaultHeader.forEach { (name, value) -> request.header(name, value) }

          // 认证请求头
          val token = jike.tokenStore.getToken(jike.mobile)
          token.accessToken?.let { request.header(Constants.ACCESS_TOKEN, it) }
          token.refreshToken?.let { request.header(Constants.REFRESH_TOKEN, it) }

          // 如果响应头中有认证请求头存下来
          val response = chain.proceed(request.build())
          val accessToken = response.header(Constants.ACCESS_TOKEN)
          val refreshToken = response.header(Constants.REFRESH_TOKEN)
          accessToken?.run {
            jike.tokenStore.setToken(jike.mobile, Token(accessToken, refreshToken))
          }
          response
        })
        .addInterceptor(Interceptor { chain: Interceptor.Chain ->
          val response = chain.proceed(chain.request())
          if (response.code == 401) {
            val token = jike.tokenStore.getToken(jike.mobile)
            if (token.accessToken.isNullOrBlank()) {
              throw NoLoginException()
            }

            // 调用刷新 token 接口
            val newToken = jike.jikeApi.refreshToken()
            if ((newToken == null) || newToken.accessToken.isNullOrBlank()) {
              throw NoLoginException()
            }

            // 如果刷新 token 报 401 直接失败, 不然会死循环
            val url = chain.request().url.toString()
            if (url.contains(REFRESH_TOKEN_URL)) {
              throw NoLoginException()
            }

            newToken.accessToken.let {
              val saveToken = Token(accessToken = newToken.accessToken, refreshToken = newToken.refreshToken)
              jike.tokenStore.setToken(jike.mobile, saveToken)

              // 刷新 token 后重新发起一次请求, 重启发起请求不会再次经过之前的普通拦截器需要主动设置 token 值(网络拦截器正常走)
              val newRequest = chain.request().newBuilder()
                .header(Constants.ACCESS_TOKEN, newToken.accessToken!!)
                .header(Constants.REFRESH_TOKEN, newToken.refreshToken!!)
                .build()
              return@Interceptor chain.proceed(newRequest)
            }
          }
          response
        })
        .build()

      return Feign.builder()
        .decoder(JacksonDecoder(listOf(KotlinModule())))
        .encoder(JacksonEncoder(listOf(KotlinModule())))
        .retryer(Retryer.NEVER_RETRY)
        .client(feign.okhttp.OkHttpClient(okHttpClient))
        .target(JikeApi::class.java, JIKE_HOST)
    }

    private val defaultHeader: Map<String, String>
      get() {
        val builder: MutableMap<String, String> = mutableMapOf()
        builder["Host"] = "api.ruguoapp.com"
        builder["client-request-id"] = UUID.randomUUID().toString().uppercase(Locale.getDefault())
        builder["user-agent"] = "jike/7.18.1 (com.ruguoapp.jike; build:1901; iOS 14.7.0) Alamofire/5.4.3"
        builder["app-buildno"] = "1901"
        builder["x-jike-device-id"] = DEVICE_ID
        builder["os"] = "ios"
        builder["manufacturer"] = "Apple"
        builder["bundleid"] = "com.ruguoapp.jike"
        builder["support-h265"] = "true"
        builder["model"] = "iPhone10,1"
        builder["app-permissions"] = "14"
        builder["app-version"] = "7.18.1"
        builder["wificonnected"] = "true"
        builder["os-version"] = "Version 14.7 (Build 18G5033e)"
        return builder
      }
  }

}
