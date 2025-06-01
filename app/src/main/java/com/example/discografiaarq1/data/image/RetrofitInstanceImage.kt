package com.example.discografiaarq1.data.image

import com.example.discografiaarq1.data.IAlbumAPI
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstanceImage {
    private val BASE_URL = "http://coverartarchive.org/"

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .header("User-Agent", "DiscographyApp/1.0 (your@email.com)")
                .build()
            chain.proceed(request)
        }
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val imageApi: IImageAPI by lazy {
        retrofit.create(IImageAPI::class.java)
    }

}