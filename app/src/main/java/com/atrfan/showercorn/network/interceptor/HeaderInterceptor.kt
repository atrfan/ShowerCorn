package com.atrfan.showercorn.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author atrfan
 * @date 2023-05-06 9:56
 */
class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(
                "user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36"
            )
            .addHeader("referer", "https://pixivic.com/")
            .addHeader("sec-fetch-dest", "image")
            .addHeader("sec-fetch-mode", "no-cors")
            .addHeader("sec-fetch-site", "cross-site")
            .build()

        return chain.proceed(request)
    }
}