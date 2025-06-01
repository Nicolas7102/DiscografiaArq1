package com.example.discografiaarq1.data.image

import com.example.musicdiscography.Album

interface IImageDataSource {
    suspend fun getImages(id: String) : List<Thumbnails>
    suspend fun getImageById(imageId: String) : Thumbnails
}