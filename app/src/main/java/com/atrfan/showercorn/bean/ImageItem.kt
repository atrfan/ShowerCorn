package com.atrfan.showercorn.bean

/**
 *
 * @property pid Int
 * @property imageUrl String
 * @property imageTitle String
 * @property artistName String
 * @constructor
 * 图片列表中的每一个item
 */
data class ImageItem(
    val pid:Int,
    val imageUrl:String,
    val imageTitle:String,
    val artistName:String
)
