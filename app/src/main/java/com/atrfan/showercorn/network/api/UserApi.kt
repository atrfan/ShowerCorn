package retrofit.pixiv

import retrofit.pixiv.pojo.UserDetails
import retrofit.pixiv.pojo.UserSearchResp
import retrofit.pixiv.pojo.UserWorks
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * @author atrfan
 * @date 2023-04-22 10:27
 */
interface UserApi {

    /**
     *
     * @author atrfan
     * @create 2023/4/22
     *
     * @param token
     * @param word 搜索词
     * @param offset 显示数量 以倍数呈现
     */
    @GET("/public/search/users")
    fun searchUsers(
        @Header("token") token:String,
        @Query("word") word:String,
        @Query("offset") offset:String
    ):Call<UserSearchResp>

    /**
     *
     * @param token String
     * @param uid Int
     * @return Call<UserDetails>
     */
    @GET("/public/search/users/details")
    fun searchUserById(
        @Header("token") token:String,
        @Query("id") uid:Int
    ):Call<UserDetails>

    /**
     *
     * @param token String
     * @param uid Int
     * @param offset Int 30倍数
     * @return Call<UserWorks>
     */
    @GET("/public/search/users/illusts")
    fun searchUserWorks(
        @Header("token") token:String,
        @Query("id") uid:Int,
        @Query("offset") offset:Int = 30,
    ):Call<UserWorks>

}