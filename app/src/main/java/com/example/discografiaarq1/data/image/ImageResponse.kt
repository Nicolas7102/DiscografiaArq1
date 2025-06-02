package com.example.discografiaarq1.data.image

data class ImageResponse(
    val images: List<Images>
)

data class Images(
    val image: String,
)