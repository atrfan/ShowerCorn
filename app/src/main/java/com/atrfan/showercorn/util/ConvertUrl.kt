package com.atrfan.showercorn.util

object ConvertUrl {

    /**
     *
     * @receiver String
     * @param type UrlType 图片url类型
     * @return String
     *
     */
    fun String.hcyagcToPixivc(type: UrlType): String = when (type) {
        UrlType.LARGE -> {
            this
                .replace(Regex("/i\\.pximg\\.net/c/.*?/img-master"), "/o.acgpic.net/img-original")
                .replace(Regex("p0_master1200\\.jpg"), "p0.png")
        }

        UrlType.MEDIUM -> {
            this.replace(Regex("i\\.pximg\\.net"), "acgpic.net")
        }

        UrlType.SQUARE_MEDIUM -> {
            this
        }
    }


    enum class UrlType {
        //原图
        LARGE,

        // 缩略图
        MEDIUM,

        SQUARE_MEDIUM
    }
}