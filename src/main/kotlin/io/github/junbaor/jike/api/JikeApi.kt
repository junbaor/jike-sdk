package io.github.junbaor.jike.api

import feign.Headers
import feign.RequestLine
import io.github.junbaor.jike.common.Constants
import io.github.junbaor.jike.common.Constants.JSON_UTF_8
import io.github.junbaor.jike.model.*

interface JikeApi {

  @Headers(Constants.JSON_UTF_8)
  @RequestLine("POST /1.0/users/loginWithPhoneAndPassword")
  fun loginWithPhoneAndPassword(body: PasswordLoginRequest)

  @RequestLine("POST /app_auth_tokens.refresh")
  fun refreshToken(): RefreshTokenResponse?

  @RequestLine("GET /1.0/users/profile")
  fun profile(): ProfileResponse?

  @Headers(JSON_UTF_8)
  @RequestLine("POST /1.0/personalUpdate/followingUpdates")
  fun followingUpdates(body: FollowingUpdatesRequest): FollowingUpdatesResponse?

}
