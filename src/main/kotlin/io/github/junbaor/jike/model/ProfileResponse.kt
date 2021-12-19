package io.github.junbaor.jike.model

data class ProfileResponse(
  val agreedProtocol: List<Any?>?,
  val enabledFeatures: List<String?>?,
  val user: User?
) {
  data class User(
    val areaCode: String?,
    val avatarImage: AvatarImage?,
    val backgroundImage: BackgroundImage?,
    val backgroundMaskColor: String?,
    val bio: String?,
    val birthday: String?,
    val briefIntro: String?,
    val city: String?,
    val country: String?,
    val createdAt: String?,
    val decorations: Decorations?,
    val gender: String?,
    val hasStories: Boolean?,
    val id: String?,
    val industry: String?,
    val isBanned: Boolean?,
    val isBannedForever: Boolean?,
    val isBetaUser: Boolean?,
    val isDefaultScreenName: Boolean?,
    val isLoginUser: Boolean?,
    val isSponsor: Boolean?,
    val isVerified: Boolean?,
    val lastChangeNameTime: String?,
    val medals: List<Medal?>?,
    val mobilePhoneNumber: String?,
    val preferences: Preferences?,
    val profileImageUrl: String?,
    val profileTags: List<ProfileTag?>?,
    val profileVisitInfo: ProfileVisitInfo?,
    val province: String?,
    val qqOpenId: String?,
    val qqUserInfo: QqUserInfo?,
    val registerAppVersion: String?,
    val restrictedAvatarChange: RestrictedAvatarChange?,
    val restrictedNameChange: RestrictedNameChange?,
    val screenName: String?,
    val showRespect: Boolean?,
    val statsCount: StatsCount?,
    val topicRoles: List<Any?>?,
    val updatedAt: String?,
    val userHasPosted: Boolean?,
    val username: String?,
    val usernameSet: Boolean?,
    val verifyMessage: String?,
    val wechatOpenId: String?,
    val wechatUnionId: String?,
    val wechatUserInfo: WechatUserInfo?,
    val weiboUid: String?,
    val zodiac: String?
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

    data class Medal(
      val badgePicUrl: String?,
      val gotMedalAt: String?,
      val name: String?,
      val picUrl: String?,
      val url: String?
    )

    data class Preferences(
      val autoPlayVideo: Boolean?,
      val blockStrangerPoke: Boolean?,
      val dailyNotificationOn: Boolean?,
      val debugLogOn: Boolean?,
      val enableChatSound: Boolean?,
      val enableOperationPush: Boolean?,
      val enablePictureWatermark: Boolean?,
      val enablePrivateChat: Boolean?,
      val env: String?,
      val followedNotificationOn: Boolean?,
      val followingUpdatesSortBy: String?,
      val hideSubscribeTab: Boolean?,
      val likeNotificationOn: Boolean?,
      val liveNotificationOn: Boolean?,
      val mentionNotificationOn: Boolean?,
      val openMessageTabOnLaunch: Boolean?,
      val paidMarket: Any?,
      val privateTopicSubscribe: Boolean?,
      val replyNotificationAllowGroup: String?,
      val repostWithComment: Boolean?,
      val respectNotificationOn: Boolean?,
      val saveDataUsageMode: Boolean?,
      val subscribeWeatherForecast: Boolean?,
      val syncCommentToPersonalActivity: Boolean?,
      val tabOnLaunch: String?,
      val topicPushSettings: String?,
      val topicTagGuideOn: Boolean?,
      val undiscoverableByPhoneNumber: Boolean?,
      val undiscoverableByWeiboUser: Boolean?
    )

    data class ProfileTag(
      val picUrl: String?,
      val text: String?,
      val type: String?
    )

    data class ProfileVisitInfo(
      val latestVisitor: LatestVisitor?,
      val todayCount: Int?
    ) {
      data class LatestVisitor(
        val avatarImage: AvatarImage?,
        val backgroundImage: BackgroundImage?,
        val bio: String?,
        val briefIntro: String?,
        val createdAt: String?,
        val decorations: Decorations?,
        val gender: String?,
        val id: String?,
        val isBannedForever: Boolean?,
        val isSponsor: Boolean?,
        val isVerified: Boolean?,
        val profileImageUrl: String?,
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
    }

    data class QqUserInfo(
      val externalName: String?,
      val id: String?
    )

    data class RestrictedAvatarChange(
      val limits: Int?,
      val nextChangeDate: String?
    )

    data class RestrictedNameChange(
      val limits: Int?,
      val nextChangeDate: String?
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

    data class WechatUserInfo(
      val externalName: String?,
      val id: String?
    )
  }
}
