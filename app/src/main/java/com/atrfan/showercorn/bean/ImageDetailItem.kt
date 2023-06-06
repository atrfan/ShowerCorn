package com.atrfan.showercorn.bean

data class ImageDetailItem(
    val imageUrl:String,
    val userHeaderUrl:String,
    val username:String,
    val uid:String,
    val imageTitle:String,
    val imageCaption:String,
    val pid:String,
    val likes:String,
    val views:String,
    val uploadTime:String,
    val tags:MutableList<String>
)