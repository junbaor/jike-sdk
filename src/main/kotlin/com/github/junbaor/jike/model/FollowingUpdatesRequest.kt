package com.github.junbaor.jike.model

data class FollowingUpdatesRequest(
  var limit: Int,
  var loadMoreKey: FollowingUpdatesResponse.LoadMoreKey?
)
