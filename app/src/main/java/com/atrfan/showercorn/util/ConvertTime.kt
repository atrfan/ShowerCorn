package com.atrfan.showercorn.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object ConvertTime {
    /**
     *
     * @receiver String responseTime
     * @return String normalTime
     * 将请求得到的时间转化为正常的时间
     * 示例：
     *  一：
     *     respTime:2023-06-01T00:00:43+09:00
     *     normalTime:2023年5月31日晚上11点00分
     *
     *  二：
     *     respTime:2023-01-10T13:31:23+09:00
     *     normalTime:2023年1月10日下午12点31分
     */
    fun String.formatTime():String{
        val time = this.split("+")[0].replace("T"," ")
        val format = DateTimeFormatter.ofPattern ("yyyy-MM-dd HH:mm:ss")
        val date = LocalDateTime.parse(time, format).plusHours(-1)
        return "${date.year}-${date.monthValue}-${date.dayOfMonth} ${date.hour}:${date.minute}"
    }
}