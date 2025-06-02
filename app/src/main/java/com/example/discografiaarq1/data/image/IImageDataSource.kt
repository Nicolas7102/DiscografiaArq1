package com.example.discografiaarq1.data.image

import Album

interface IImageDataSource {
    suspend fun getImages(id: String) : String
    suspend fun getImageById(imageId: String) : String
}