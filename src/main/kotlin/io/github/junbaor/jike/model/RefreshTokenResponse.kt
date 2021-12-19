package io.github.junbaor.jike.model

import com.fasterxml.jackson.annotation.JsonProperty

data class RefreshTokenResponse(
  @JsonProperty("success")
  var isSuccess: Boolean = false,

  @JsonProperty("x-jike-access-token")
  var accessToken: String? = null,

  @JsonProperty("x-jike-refresh-token")
  var refreshToken: String? = null
)
