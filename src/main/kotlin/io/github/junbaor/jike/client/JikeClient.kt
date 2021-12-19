package io.github.junbaor.jike.client

import io.github.junbaor.jike.api.JikeApi
import io.github.junbaor.jike.api.JikeApiFactory.Companion.create
import io.github.junbaor.jike.exception.NoLoginException
import io.github.junbaor.jike.model.FollowingUpdatesRequest
import io.github.junbaor.jike.model.FollowingUpdatesResponse
import io.github.junbaor.jike.model.PasswordLoginRequest
import io.github.junbaor.jike.model.ProfileResponse
import io.github.junbaor.jike.persistence.DiskTokenPersistence
import io.github.junbaor.jike.persistence.TokenPersistence

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

  fun followingUpdates(limit: Int): FollowingUpdatesResponse? {
    return jikeApi.followingUpdates(FollowingUpdatesRequest(limit, null))
  }

  fun followingUpdates(limit: Int, loadMoreKey: FollowingUpdatesResponse.LoadMoreKey?): FollowingUpdatesResponse? {
    return jikeApi.followingUpdates(FollowingUpdatesRequest(limit, loadMoreKey))
  }

}
