package retrofit.pixiv.pojo


import com.google.gson.annotations.SerializedName

data class PublicSetuResp(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("msg")
    val msg: String
) {
    data class Data(
        @SerializedName("caption")
        val caption: String,
        @SerializedName("createDate")
        val createDate: String,
        @SerializedName("height")
        val height: String,
        @SerializedName("illust")
        val illust: String,
        @SerializedName("isBookmarked")
        val isBookmarked: String,
        @SerializedName("isMuted")
        val isMuted: String,
        @SerializedName("large")
        val large: String,
        @SerializedName("originals")
        val originals: List<Original>,
        @SerializedName("pageCount")
        val pageCount: String,
        @SerializedName("restrict")
        val restrict: String,
        @SerializedName("sanityLevel")
        val sanityLevel: String,
        @SerializedName("tags")
        val tags: List<Tag>,
        @SerializedName("title")
        val title: String,
        @SerializedName("totalBookmarks")
        val totalBookmarks: String,
        @SerializedName("totalComments")
        val totalComments: String,
        @SerializedName("totalView")
        val totalView: String,
        @SerializedName("type")
        val type: String,
        @SerializedName("user")
        val user: User,
        @SerializedName("visible")
        val visible: String,
        @SerializedName("width")
        val width: String,
        @SerializedName("xRestrict")
        val xRestrict: String
    ) {
        data class Original(
            @SerializedName("url")
            val url: String
        )

        data class Tag(
            @SerializedName("name")
            val name: String
        )

        data class User(
            @SerializedName("account")
            val account: String,
            @SerializedName("id")
            val id: String,
            @SerializedName("isFollowed")
            val isFollowed: String,
            @SerializedName("name")
            val name: String,
            @SerializedName("profileImageUrls")
            val profileImageUrls: String
        )
    }
}