package retrofit.pixiv

import retrofit.pixiv.pojo.IllustDetailResp
import retrofit.pixiv.pojo.IllustRankingResp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import java.time.LocalDate

interface IllustsApi {
    /**
     * @author atrfan
     * @create 2023/4/20
     *
     * @param token
     * @param mode 模式
     * @param date 日期，如：2023-04-20
     * @param offset （n-1)*30
     * 示例：illusts/ranking?mode=day&date=2020-05-13
     */
    @GET("/illusts/ranking")
    fun ranking(
        @Header("token") token: String,
        @Query("mode") mode: String = "day",
        @Query("date") date: String = LocalDate.now().plusDays(-1).toString(),
        @Query("offset") offset: Int = 0
    ): Call<IllustRankingResp>

    /**
     *
     * @param token String
     * @param pid Int 插画id
     * @param reduction Boolean true则返回pixiv原始数据，否则默认返回本站数据
     * @return Call<IllustDetailResp>
     *
     */
    @GET("/illusts/detail")
    fun detail(
        @Header("token") token: String,
        @Query("illustId") pid:Int,
        @Query("reduction") reduction:Boolean = true
    ):Call<IllustDetailResp>

}