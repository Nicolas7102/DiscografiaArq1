package com.example.discografiaarq1.data.image

data class ImageResponse(
    val images: List<Images>
)

data class Images(
    val thumbnails: List<Thumbnails>
)

data class Thumbnails(
    //val large: String?,
    val small: String?,
)