package com.atrfan.showercorn.network.response

import com.atrfan.showercorn.bean.ImageItem
import com.atrfan.showercorn.network.client.HttpFactory
import com.atrfan.showercorn.util.ConvertUrl
import com.atrfan.showercorn.util.ConvertUrl.hcyagcToPixivc
import com.atrfan.showercorn.network.api.PublicApi

class ListResponse {

    // 是否允许有R18图
    private val R18 = false

    suspend fun allRank(mode:String, page: Int): MutableList<ImageItem> {
        val imageList = mutableListOf<ImageItem>()
        val client = HttpFactory.client
        val service = client.create(PublicApi::class.java)
        val response = service.ranking(
            token = HttpFactory.apiKey,
            rankType = "all",
            mode = mode,
            page = page,
            perPage = 30
        ).execute().body()
        val list = response?.illusts

        list?.forEach {
            // 判断是否含有R18的tag
            var containR18 = false
            it.tags.forEach {tag ->
                if (tag.name == "R-18"){
                    containR18 =  true
                }
            }

            if(R18||!containR18){
                val imageUrl = it.imageUrls.medium.hcyagcToPixivc(ConvertUrl.UrlType.MEDIUM)
                val img = ImageItem(it.id, imageUrl, it.title, it.user.name)
                imageList.add(img)
            }
        }
        return imageList
    }

    suspend fun rankByTag(tag:String,page:Int): MutableList<ImageItem> {
        val imageList = mutableListOf<ImageItem>()
        val client = HttpFactory.client
        val service = client.create(PublicApi::class.java)
        val response = service.search(
            token = HttpFactory.apiKey,
            tag = tag,
            offset = page
        ).execute().body()
        val list = response?.illusts

        list?.forEach {
            // 判断是否含有R18的tag
            var containR18 = false
            it.tags.forEach {tag ->
                if (tag.name == "R-18"){
                    containR18 =  true
                }
            }

            if(R18||!containR18){
                val imageUrl = it.imageUrls.medium.hcyagcToPixivc(ConvertUrl.UrlType.MEDIUM)
                val img = ImageItem(it.id, imageUrl, it.title, it.user.name)
                imageList.add(img)
            }
        }
        return imageList
    }

    suspend fun rankByWorkType(type:String,page:Int): MutableList<ImageItem> {
        val imageList = mutableListOf<ImageItem>()
        val client = HttpFactory.client
        val service = client.create(PublicApi::class.java)
        val response = service.ranking(
            token = HttpFactory.apiKey,
            rankType = type,
            mode = "daily",
            page = page,
            perPage = 30
        ).execute().body()
        val list = response?.illusts

        list?.forEach {
            // 判断是否含有R18的tag
            var containR18 = false
            it.tags.forEach {tag ->
                if (tag.name == "R-18"){
                    containR18 =  true
                }
            }

            if(R18||!containR18){
                val imageUrl = it.imageUrls.medium.hcyagcToPixivc(ConvertUrl.UrlType.MEDIUM)
                val img = ImageItem(it.id, imageUrl, it.title, it.user.name)
                imageList.add(img)
            }
        }
        return imageList
    }


}