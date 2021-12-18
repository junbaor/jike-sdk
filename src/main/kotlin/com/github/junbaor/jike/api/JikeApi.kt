package com.github.junbaor.jike.api

import com.github.junbaor.jike.common.Constants
import com.github.junbaor.jike.model.PasswordLoginRequest
import com.github.junbaor.jike.model.ProfileResponse
import com.github.junbaor.jike.model.RefreshTokenResponse
import feign.Headers
import feign.RequestLine

interface JikeApi {

  @Headers(Constants.JSON_UTF_8)
  @RequestLine("POST /1.0/users/loginWithPhoneAndPassword")
  fun loginWithPhoneAndPassword(body: PasswordLoginRequest)

  @RequestLine("POST /app_auth_tokens.refresh")
  fun refreshToken(): RefreshTokenResponse?

  @RequestLine("GET /1.0/users/profile")
  fun profile(): ProfileResponse?

}
