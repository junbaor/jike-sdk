package com.github.junbaor.jike.model

data class FollowingUpdatesResponse(
  val `data`: List<Data?>?,
  val loadMoreKey: LoadMoreKey?,
  val success: Boolean?
) {
  data class Data(
    val action: String?,
    val actionTime: String?,
    val collectTime: Any?,
    val collected: Boolean?,
    val commentCount: Int?,
    val content: String?,
    val createdAt: String?,
    val enablePictureComments: Boolean?,
    val id: String?,
    val isCommentForbidden: Boolean?,
    val isFeatured: Boolean?,
    val likeCount: Int?,
    val likeIcon: String?,
    val liked: Boolean?,
    val linkInfo: LinkInfo?,
    val pictures: List<Picture?>?,
    val poi: Poi?,
    val readTrackInfo: ReadTrackInfo?,
    val repostCount: Int?,
    val repostable: Boolean?,
    val rollouts: Rollouts?,
    val rootType: String?,
    val scrollingSubtitles: List<ScrollingSubtitle?>?,
    val shareCount: Int?,
    val status: String?,
    val syncCommentId: String?,
    val target: Target?,
    val targetType: String?,
    val targetUsernames: List<String?>?,
    val targetUsers: List<TargetUser?>?,
    val topic: Topic?,
    val type: String?,
    val updateIds: List<String?>?,
    val urlsInText: List<UrlsInText?>?,
    val user: User?,
    val usernames: List<String?>?,
    val users: List<User?>?
  ) {
    data class LinkInfo(
      val `abstract`: String?,
      val linkUrl: String?,
      val pictureUrl: String?,
      val source: String?,
      val title: String?
    )

    data class Picture(
      val cropperPosX: Double?,
      val cropperPosY: Double?,
      val format: String?,
      val frameNumber: Int?,
      val height: Int?,
      val key: String?,
      val middlePicUrl: String?,
      val picUrl: String?,
      val smallPicUrl: String?,
      val thumbnailUrl: String?,
      val watermarkPicUrl: String?,
      val width: Int?
    )

    data class Poi(
      val cityname: String?,
      val countryname: String?,
      val formattedAddress: String?,
      val location: List<Double?>?,
      val name: String?,
      val pname: String?,
      val poiId: String?
    )

    data class ReadTrackInfo(
      val feedType: String?,
      val loadedAt: Long?,
      val storyStatus: String?
    )

    data class Rollouts(
      val wmpShare: WmpShare?
    ) {
      data class WmpShare(
        val id: String?,
        val path: String?
      )
    }

    data class ScrollingSubtitle(
      val text: String?,
      val type: String?
    )

    data class Target(
      val collectTime: Any?,
      val collected: Boolean?,
      val commentCount: Int?,
      val content: String?,
      val createdAt: String?,
      val enablePictureComments: Boolean?,
      val id: String?,
      val isCommentForbidden: Boolean?,
      val isFeatured: Boolean?,
      val likeCount: Int?,
      val pictures: List<Any?>?,
      val repostCount: Int?,
      val repostable: Boolean?,
      val rollouts: Rollouts?,
      val scrollingSubtitles: List<ScrollingSubtitle?>?,
      val shareCount: Int?,
      val status: String?,
      val subtitle: String?,
      val topic: Topic?,
      val type: String?,
      val urlsInText: List<UrlsInText?>?,
      val user: User?,
      val video: Video?
    ) {
      data class Rollouts(
        val wmpShare: WmpShare?
      ) {
        data class WmpShare(
          val id: String?,
          val path: String?
        )
      }

      data class ScrollingSubtitle(
        val text: String?,
        val type: String?
      )

      data class Topic(
        val activitySection: Any?,
        val activitySections: List<Any?>?,
        val approximateSubscribersCount: String?,
        val auditStatus: String?,
        val botCount: Int?,
        val briefIntro: String?,
        val content: String?,
        val createdAt: String?,
        val customTags: List<Any?>?,
        val enableForUserPost: Boolean?,
        val enablePictureComments: Boolean?,
        val enablePictureWatermark: Boolean?,
        val entryTab: String?,
        val friendsAlsoSubscribe: String?,
        val id: String?,
        val inShortcuts: Boolean?,
        val internalTags: List<Any?>?,
        val intro: String?,
        val involvedUsers: Any?,
        val isAnonymous: Boolean?,
        val isCommentForbidden: Boolean?,
        val isDreamTopic: Boolean?,
        val isSearchable: Boolean?,
        val isUserTopicAdmin: Boolean?,
        val isValid: Boolean?,
        val isVerified: Boolean?,
        val lastMessagePostTime: String?,
        val likeIcon: String?,
        val maintainer: Any?,
        val messagePrefix: String?,
        val newCategory: List<Any?>?,
        val operateStatus: String?,
        val pictureUrl: String?,
        val preferSection: String?,
        val recentPost: String?,
        val rectanglePicture: Any?,
        val ref: String?,
        val relatedHashtags: List<Any?>?,
        val source: String?,
        val squarePicture: SquarePicture?,
        val squarePostUpdateTime: String?,
        val subscribedAt: String?,
        val subscribedStatusRawValue: Int?,
        val subscribersAction: String?,
        val subscribersCount: Int?,
        val subscribersDescription: String?,
        val subscribersName: String?,
        val subscribersTextSuffix: String?,
        val tabs: List<Any?>?,
        val thumbnailUrl: String?,
        val timeForRank: String?,
        val tips: Tips?,
        val topicId: Int?,
        val topicType: String?,
        val toppingArea: Any?,
        val type: String?,
        val updatedAt: String?
      ) {
        data class SquarePicture(
          val format: String?,
          val livePhoto: Any?,
          val middlePicUrl: String?,
          val picUrl: String?,
          val smallPicUrl: String?,
          val themes: Themes?,
          val thumbnailUrl: String?
        ) {
          class Themes
        }

        data class Tips(
          val inComment: String?,
          val inDraft: String?
        )
      }

      data class UrlsInText(
        val originalUrl: String?,
        val title: String?,
        val type: String?,
        val url: String?
      )

      data class User(
        val avatarImage: AvatarImage?,
        val backgroundImage: BackgroundImage?,
        val bio: String?,
        val briefIntro: String?,
        val city: String?,
        val country: String?,
        val createdAt: String?,
        val decorations: Decorations?,
        val gender: String?,
        val id: String?,
        val isBannedForever: Boolean?,
        val isSponsor: Boolean?,
        val isVerified: Boolean?,
        val profileImageUrl: String?,
        val province: String?,
        val ref: String?,
        val refRemark: RefRemark?,
        val screenName: String?,
        val sponsorExpiresAt: String?,
        val statsCount: StatsCount?,
        val updatedAt: String?,
        val username: String?,
        val verifyMessage: String?
      ) {
        data class AvatarImage(
          val format: String?,
          val middlePicUrl: String?,
          val picUrl: String?,
          val smallPicUrl: String?,
          val thumbnailUrl: String?
        )

        data class BackgroundImage(
          val picUrl: String?
        )

        data class Decorations(
          val sponsor: Sponsor?
        ) {
          data class Sponsor(
            val picUrl: String?,
            val themes: Themes?
          ) {
            data class Themes(
              val dark: Dark?
            ) {
              data class Dark(
                val picUrl: String?
              )
            }
          }
        }

        data class RefRemark(
          val refId: String?,
          val type: String?
        )

        data class StatsCount(
          val followedCount: Int?,
          val followingCount: Int?,
          val highlightedPersonalUpdates: Int?,
          val liked: Int?,
          val respectedCount: Int?,
          val topicCreated: Int?,
          val topicSubscribed: Int?
        )
      }

      data class Video(
        val duration: Int?,
        val height: Int?,
        val image: Image?,
        val type: String?,
        val width: Int?
      ) {
        data class Image(
          val format: String?,
          val picUrl: String?,
          val thumbnailUrl: String?
        )
      }
    }

    data class TargetUser(
      val avatarImage: AvatarImage?,
      val backgroundImage: BackgroundImage?,
      val bio: String?,
      val briefIntro: String?,
      val city: String?,
      val country: String?,
      val createdAt: String?,
      val decorations: Decorations?,
      val gender: String?,
      val id: String?,
      val isBannedForever: Boolean?,
      val isSponsor: Boolean?,
      val isVerified: Boolean?,
      val profileImageUrl: String?,
      val province: String?,
      val ref: String?,
      val screenName: String?,
      val statsCount: StatsCount?,
      val updatedAt: String?,
      val username: String?,
      val verifyMessage: String?
    ) {
      data class AvatarImage(
        val format: String?,
        val middlePicUrl: String?,
        val picUrl: String?,
        val smallPicUrl: String?,
        val thumbnailUrl: String?
      )

      data class BackgroundImage(
        val picUrl: String?
      )

      class Decorations

      data class StatsCount(
        val followedCount: Int?,
        val followingCount: Int?,
        val highlightedPersonalUpdates: Int?,
        val liked: Int?,
        val respectedCount: Int?,
        val topicCreated: Int?,
        val topicSubscribed: Int?
      )
    }

    data class Topic(
      val activitySection: Any?,
      val activitySections: List<Any?>?,
      val approximateSubscribersCount: String?,
      val auditStatus: String?,
      val botCount: Int?,
      val briefIntro: String?,
      val content: String?,
      val createdAt: String?,
      val customTags: List<Any?>?,
      val enableForUserPost: Boolean?,
      val enablePictureComments: Boolean?,
      val enablePictureWatermark: Boolean?,
      val entryTab: String?,
      val friendsAlsoSubscribe: String?,
      val id: String?,
      val inShortcuts: Boolean?,
      val internalTags: List<Any?>?,
      val intro: String?,
      val involvedUsers: Any?,
      val isAnonymous: Boolean?,
      val isCommentForbidden: Boolean?,
      val isDreamTopic: Boolean?,
      val isSearchable: Boolean?,
      val isUserTopicAdmin: Boolean?,
      val isValid: Boolean?,
      val isVerified: Boolean?,
      val lastMessagePostTime: String?,
      val likeIcon: String?,
      val maintainer: Any?,
      val messagePrefix: String?,
      val newCategory: List<Any?>?,
      val operateStatus: String?,
      val pictureUrl: String?,
      val preferSection: String?,
      val recentPost: String?,
      val rectanglePicture: Any?,
      val ref: String?,
      val relatedHashtags: List<Any?>?,
      val source: String?,
      val squarePicture: SquarePicture?,
      val squarePostUpdateTime: String?,
      val subscribedAt: String?,
      val subscribedStatusRawValue: Int?,
      val subscribersAction: String?,
      val subscribersCount: Int?,
      val subscribersDescription: String?,
      val subscribersName: String?,
      val subscribersTextSuffix: String?,
      val tabs: List<Any?>?,
      val thumbnailUrl: String?,
      val timeForRank: String?,
      val tips: Tips?,
      val topicId: Int?,
      val topicType: String?,
      val toppingArea: Any?,
      val type: String?,
      val updatedAt: String?
    ) {
      data class SquarePicture(
        val format: String?,
        val livePhoto: Any?,
        val middlePicUrl: String?,
        val picUrl: String?,
        val smallPicUrl: String?,
        val themes: Themes?,
        val thumbnailUrl: String?
      ) {
        class Themes
      }

      data class Tips(
        val inComment: String?,
        val inDraft: String?
      )
    }

    data class UrlsInText(
      val originalUrl: String?,
      val title: String?,
      val type: String?,
      val url: String?
    )

    data class User(
      val avatarImage: AvatarImage?,
      val backgroundImage: BackgroundImage?,
      val bio: String?,
      val briefIntro: String?,
      val city: String?,
      val country: String?,
      val createdAt: String?,
      val decorations: Decorations?,
      val gender: String?,
      val id: String?,
      val isBannedForever: Boolean?,
      val isSponsor: Boolean?,
      val isVerified: Boolean?,
      val profileImageUrl: String?,
      val province: String?,
      val ref: String?,
      val screenName: String?,
      val statsCount: StatsCount?,
      val storyStatus: String?,
      val updatedAt: String?,
      val username: String?,
      val verifyMessage: String?
    ) {
      data class AvatarImage(
        val format: String?,
        val middlePicUrl: String?,
        val picUrl: String?,
        val smallPicUrl: String?,
        val thumbnailUrl: String?
      )

      data class BackgroundImage(
        val picUrl: String?
      )

      class Decorations

      data class StatsCount(
        val followedCount: Int?,
        val followingCount: Int?,
        val highlightedPersonalUpdates: Int?,
        val liked: Int?,
        val respectedCount: Int?,
        val topicCreated: Int?,
        val topicSubscribed: Int?
      )
    }
  }

  data class LoadMoreKey(
    val lastPageEarliestTime: Long?,
    val lastReadTime: Long?,
    val session: String?
  )
}
