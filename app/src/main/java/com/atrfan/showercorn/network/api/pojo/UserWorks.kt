package retrofit.pixiv.pojo


import com.google.gson.annotations.SerializedName

data class UserWorks(
    @SerializedName("illusts")
    val illusts: List<Illust>,
    @SerializedName("next_url")
    val nextUrl: String,
    @SerializedName("user")
    val user: User
) {
    data class Illust(
        @SerializedName("caption")
        val caption: String,
        @SerializedName("create_date")
        val createDate: String,
        @SerializedName("height")
        val height: Int,
        @SerializedName("id")
        val id: Int,
        @SerializedName("illust_ai_type")
        val illustAiType: Int,
        @SerializedName("illust_book_style")
        val illustBookStyle: Int,
        @SerializedName("image_urls")
        val imageUrls: ImageUrls,
        @SerializedName("is_bookmarked")
        val isBookmarked: Boolean,
        @SerializedName("is_muted")
        val isMuted: Boolean,
        @SerializedName("meta_pages")
        val metaPages: List<MetaPage>,
        @SerializedName("meta_single_page")
        val metaSinglePage: MetaSinglePage,
        @SerializedName("page_count")
        val pageCount: Int,
        @SerializedName("restrict")
        val restrict: Int,
        @SerializedName("sanity_level")
        val sanityLevel: Int,
        @SerializedName("tags")
        val tags: List<Tag>,
        @SerializedName("title")
        val title: String,
        @SerializedName("tools")
        val tools: List<String>,
        @SerializedName("total_bookmarks")
        val totalBookmarks: Int,
        @SerializedName("total_comments")
        val totalComments: Int,
        @SerializedName("total_view")
        val totalView: Int,
        @SerializedName("type")
        val type: String,
        @SerializedName("user")
        val user: User,
        @SerializedName("visible")
        val visible: Boolean,
        @SerializedName("width")
        val width: Int,
        @SerializedName("x_restrict")
        val xRestrict: Int
    ) {
        data class ImageUrls(
            @SerializedName("large")
            val large: String,
            @SerializedName("medium")
            val medium: String,
            @SerializedName("square_medium")
            val squareMedium: String
        )

        data class MetaPage(
            @SerializedName("image_urls")
            val imageUrls: ImageUrls
        ) {
            data class ImageUrls(
                @SerializedName("large")
                val large: String,
                @SerializedName("medium")
                val medium: String,
                @SerializedName("original")
                val original: String,
                @SerializedName("square_medium")
                val squareMedium: String
            )
        }

        data class MetaSinglePage(
            @SerializedName("original_image_url")
            val originalImageUrl: String
        )

        data class Tag(
            @SerializedName("name")
            val name: String,
            @SerializedName("translated_name")
            val translatedName: String
        )

        data class User(
            @SerializedName("account")
            val account: String,
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
    }

    data class User(
        @SerializedName("account")
        val account: String,
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
}