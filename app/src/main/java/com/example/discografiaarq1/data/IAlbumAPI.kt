package com.example.discografiaarq1.data

import Album
import AlbumDetailResponse
import AlbumResponse
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IAlbumAPI {
    @GET("release-group")

    suspend fun getAlbumSearch(
        @Query("query") search: String,
        @Query("fmt") format: String = "json"
    ) : AlbumResponse

    @GET("release-group/{id}")
    suspend fun getAlbum(
        @Path("id") albumId: String,
        @Query("inc") include: String ="releases+artist-credits",
        @Query("fmt") format: String = "json"
    ) : Album //Hacer uno para Tracks
}
