package com.example.discografiaarq1.data.image

import AlbumResponse
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IImageAPI {
    @GET("release-group/{id}")
    suspend fun getImageSearch(
        @Path("id")
        releaseId: String,
    ) : ImageResponse
}
