package com.atrfan.showercorn.network.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpFactory {
    @JvmStatic
    private val baseUrl = "https://api.acgmx.com"

    @JvmStatic
    val apiKey =
        "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhdHJmYW4iLCJ1dWlkIjoiNmY2Zjg3NzM2ZDc2NGRjOGJiMzQ3NDI1OTEzMTBjNWQiLCJpYXQiOjE2NzA1OTk1NzUsImFjY291bnQiOiJ7XCJlbWFpbFwiOlwiYXRyZmFuMEBnbWFpbC5jb21cIixcImdlbmRlclwiOi0xLFwiaGFzUHJvblwiOjAsXCJpZFwiOjI0MTksXCJwYXNzV29yZFwiOlwiOTE2ODIyNDljYzQyNzc1YmNkZTUxMDViYzY3NDE2Y2JcIixcInN0YXR1c1wiOjAsXCJ1c2VyTmFtZVwiOlwiYXRyZmFuXCJ9IiwianRpIjoiMjQxOSJ9.XuK-aHSV3ttESWLEk-1A1xP4eTlEKQsMUBjX5z5ePIM"

    @JvmStatic
    private var _client = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val client: Retrofit
        get() = _client
}