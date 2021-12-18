package com.github.junbaor.jike.client

import com.github.junbaor.jike.api.JikeApi
import com.github.junbaor.jike.api.JikeApiFactory.Companion.create
import com.github.junbaor.jike.exception.NoLoginException
import com.github.junbaor.jike.model.PasswordLoginRequest
import com.github.junbaor.jike.model.ProfileResponse
import com.github.junbaor.jike.persistence.DiskTokenPersistence
import com.github.junbaor.jike.persistence.TokenPersistence

class JikeClient constructor(
  val areaCode: String,
  val mobile: String,
  private val password: String,
  val tokenStore: TokenPersistence = DiskTokenPersistence(
    System.getProperty("user.home") + "/.jike/" + mobile + ".ini"
  )
) {
  val jikeApi: JikeApi = create(this)

  init {
    try {
      jikeApi.profile()
    } catch (e: NoLoginException) {
      val request = PasswordLoginRequest(areaCode, mobile, password)
      jikeApi.loginWithPhoneAndPassword(request)
      jikeApi.profile()
    }
  }

  fun profile(): ProfileResponse? {
    return jikeApi.profile()
  }
}
