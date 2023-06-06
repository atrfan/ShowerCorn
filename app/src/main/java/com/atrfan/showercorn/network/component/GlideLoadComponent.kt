package com.atrfan.showercorn.network.component

import android.content.Context
import com.atrfan.showercorn.network.interceptor.HeaderInterceptor
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import okhttp3.OkHttpClient
import java.io.InputStream

/**
 * @author atrfan
 * @date 2023-05-05 22:03
 */

@GlideModule
class GlideLoadComponent : AppGlideModule() {
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        super.registerComponents(context, glide, registry)
        registry.replace(
            GlideUrl::class.java,
            InputStream::class.java,
            OkHttpUrlLoader.Factory(
                OkHttpClient.Builder()
                    .addInterceptor(HeaderInterceptor())
                    .build()
            )
        )
    }
}