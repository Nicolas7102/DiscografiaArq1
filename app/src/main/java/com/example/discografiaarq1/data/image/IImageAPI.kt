package com.example.discografiaarq1.data.image

import com.example.musicdiscography.AlbumResponse
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IImageAPI {
    @GET("release-group")

    suspend fun getImageSearch(
        @Query("release/") search: String,
        @Query("fmt") format: String = "json"
    ) : AlbumResponse

    @GET("release{id}")
    suspend fun getAlbumById(
        @Path("id") albumId: String,
        @Query("fmt") format: String = "json"
    ) : AlbumResponse
}
