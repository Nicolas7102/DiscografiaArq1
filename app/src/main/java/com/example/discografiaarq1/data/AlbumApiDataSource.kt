package com.example.discografiaarq1.data

import android.util.Log
import com.example.musicdiscography.Album
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AlbumApiDataSource : IAlbumDataSource{
    val BASE_URL = "https://musicbrainz.org/ws/2/"

    val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .header("User-Agent", "DiscographyApp/1.0 (your@email.com)")
                .build()
            chain.proceed(request)
        }
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(IAlbumAPI::class.java)

    override suspend fun getAlbums(): List<Album> {
        Log.d("DiscographyApp", "AlbumApiDataSource.getAlbums()")

        var prefix = "release:\""
        var albumInput = "efil4zaggin"
        var suffix = "\""
        var query = prefix + albumInput + suffix
        val albumResponse = api.getAlbumSearch(query)

        Log.d("DiscographyApp", "AlbumApiDataSource.getAlbums Result: ${albumResponse.albums.size}")
        return albumResponse.albums
    }
}