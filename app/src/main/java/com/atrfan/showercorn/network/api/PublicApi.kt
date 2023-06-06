package com.atrfan.showercorn.network.api

import retrofit.pixiv.pojo.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import java.time.LocalDate

/**
 *
 * 公共接口，包含了获取排行榜、搜索、涩图三个功能
 * 各参数见：https://api.hcyacg.com/#/public/ranking
 */


interface PublicApi {

    /**
     *
     * @param token String
     * @param rankType String 排行榜类型，分：all、illust(插画)、manga(漫画)、ugoira(动图)
     * @param mode String 模式，分:daily、weekly、monthly、rookie、original、male、female、daily_r18、weekly_r18、male_r18、female_r18、r18g
     * @param page Int
     * @param perPage Int
     * @param date String
     * @return Call<PublicRankingResp>
     *
     */
    @GET("/public/ranking")
    fun ranking(
        @Header("token") token: String,
        @Query("ranking_type") rankType: String = "all",
        @Query("mode") mode: String = "daily",
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 10,
        @Query("date") date: String = LocalDate.now().plusDays(-2).toString()
    ): Call<PublicRankingResp>

    /**
     *
     * @param token String
     * @param tag String 查询关键词
     * @param offset Int 30的倍数
     * @return Call<PublicSearchResp>
     *
     * 根据关键词搜索图片
     */
    @GET("/public/search")
    fun search(
        @Header("token") token: String,
        @Query("q") tag: String = "猫耳",
        @Query("offset") offset: Int = 30
    ): Call<PublicSearchResp>

    /**
     *
     * @param token String
     * @return Call<PublicSetuResp>
     *
     * 接口暂时不可用
     * 随机返回一张涩图
     */
    @GET("/public/setu")
    fun setu(@Header("token") token: String):Call<PublicSetuResp>
}