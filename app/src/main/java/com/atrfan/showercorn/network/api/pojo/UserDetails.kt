package retrofit.pixiv.pojo


import com.google.gson.annotations.SerializedName

data class UserDetails(
    @SerializedName("profile")
    val profile: Profile,
    @SerializedName("profile_publicity")
    val profilePublicity: ProfilePublicity,
    @SerializedName("user")
    val user: User,
    @SerializedName("workspace")
    val workspace: Workspace
) {
    data class Profile(
        @SerializedName("address_id")
        val addressId: Int,
        @SerializedName("background_image_url")
        val backgroundImageUrl: String,
        @SerializedName("birth")
        val birth: String,
        @SerializedName("birth_day")
        val birthDay: String,
        @SerializedName("birth_year")
        val birthYear: Int,
        @SerializedName("country_code")
        val countryCode: String,
        @SerializedName("gender")
        val gender: String,
        @SerializedName("is_premium")
        val isPremium: Boolean,
        @SerializedName("is_using_custom_profile_image")
        val isUsingCustomProfileImage: Boolean,
        @SerializedName("job")
        val job: String,
        @SerializedName("job_id")
        val jobId: Int,
        @SerializedName("region")
        val region: String,
        @SerializedName("total_follow_users")
        val totalFollowUsers: Int,
        @SerializedName("total_illust_bookmarks_public")
        val totalIllustBookmarksPublic: Int,
        @SerializedName("total_illust_series")
        val totalIllustSeries: Int,
        @SerializedName("total_illusts")
        val totalIllusts: Int,
        @SerializedName("total_manga")
        val totalManga: Int,
        @SerializedName("total_mypixiv_users")
        val totalMypixivUsers: Int,
        @SerializedName("total_novel_series")
        val totalNovelSeries: Int,
        @SerializedName("total_novels")
        val totalNovels: Int,
        @SerializedName("twitter_account")
        val twitterAccount: String,
        @SerializedName("twitter_url")
        val twitterUrl: String,
        @SerializedName("webpage")
        val webpage: String
    )

    data class ProfilePublicity(
        @SerializedName("birth_day")
        val birthDay: String,
        @SerializedName("birth_year")
        val birthYear: String,
        @SerializedName("gender")
        val gender: String,
        @SerializedName("job")
        val job: String,
        @SerializedName("pawoo")
        val pawoo: Boolean,
        @SerializedName("region")
        val region: String
    )

    data class User(
        @SerializedName("account")
        val account: String,
        @SerializedName("comment")
        val comment: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("is_access_blocking_user")
        val isAccessBlockingUser: Boolean,
        @SerializedName("is_followed")
        val isFollowed: Boolean,
        @SerializedName("name")
        val name: String,
        @SerializedName("profile_image_urls")
        val profileImageUrls: ProfileImageUrls
    ) {
        data class ProfileImageUrls(
            @SerializedName("medium")
            val medium: String
        )
    }

    data class Workspace(
        @SerializedName("chair")
        val chair: String,
        @SerializedName("comment")
        val comment: String,
        @SerializedName("desk")
        val desk: String,
        @SerializedName("desktop")
        val desktop: String,
        @SerializedName("monitor")
        val monitor: String,
        @SerializedName("mouse")
        val mouse: String,
        @SerializedName("music")
        val music: String,
        @SerializedName("pc")
        val pc: String,
        @SerializedName("printer")
        val printer: String,
        @SerializedName("scanner")
        val scanner: String,
        @SerializedName("tablet")
        val tablet: String,
        @SerializedName("tool")
        val tool: String,
        @SerializedName("workspace_image_url")
        val workspaceImageUrl: String
    )
}