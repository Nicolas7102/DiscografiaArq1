package com.example.discografiaarq1.data.image

import Album
import retrofit2.http.GET
import retrofit2.http.Path

interface IImageRepository {
    @GET("/release/{id}/")
    suspend fun fetchImages(@Path("releaseId") releaseId : String): String
}