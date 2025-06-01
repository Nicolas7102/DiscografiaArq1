package com.example.discografiaarq1.data.image

import com.example.musicdiscography.Album

interface IImageRepository {
    suspend fun fetchImages(id: String) : List<Thumbnails>
}