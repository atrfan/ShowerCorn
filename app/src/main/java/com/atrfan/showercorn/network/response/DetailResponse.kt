package com.atrfan.showercorn.network.response

import android.text.Html
import com.atrfan.showercorn.bean.ImageDetailItem
import com.atrfan.showercorn.network.client.HttpFactory
import com.atrfan.showercorn.util.ConvertUrl
import com.atrfan.showercorn.util.ConvertUrl.hcyagcToPixivc
import retrofit.pixiv.IllustsApi

class DetailResponse {
    suspend fun imageDetail(pid: String, flag: Boolean = true): ImageDetailItem? {
        val client = HttpFactory.client
        val service = client.create(IllustsApi::class.java)
        val response = service.detail(
            token = HttpFactory.apiKey,
            pid = pid.toInt(),
            reduction = flag
        ).execute().body()
        response?.data?.illust?.let {
            val imageUrl = it.imageUrls.medium.hcyagcToPixivc(ConvertUrl.UrlType.MEDIUM)
            val userHeaderUrl =
                it.user.profileImageUrls.medium.hcyagcToPixivc(ConvertUrl.UrlType.MEDIUM)
            val username = it.user.name
            val uid = "uid:${it.user.id}"
            val imageTitle = it.title
            val imageCaption = Html.fromHtml(it.caption, Html.FROM_HTML_MODE_LEGACY).toString()
            val pid = "pid:${it.id}"
            val likes = it.totalBookmarks
            val views = it.totalView
            val uploadTime = it.createDate
            val tags = mutableListOf<String>()
            it.tags.forEach { tag ->
                tags.add(tag.name)
            }

            return ImageDetailItem(
                imageUrl,
                userHeaderUrl,
                username,
                uid,
                imageTitle,
                imageCaption,
                pid,
                likes.toString(),
                views.toString(),
                uploadTime,
                tags
            )
        }
        return null
    }
}