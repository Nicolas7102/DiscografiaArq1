package com.example.discografiaarq1.data.image

import com.example.discografiaarq1.data.AlbumApiDataSource
import com.example.discografiaarq1.data.IAlbumDataSource
import com.example.discografiaarq1.domain.IAlbumRepository
import com.example.musicdiscography.Album

class ImageRepository (val imageDataSource: IImageDataSource = ImageApiDataSource())
    : IImageRepository
{
    override suspend fun fetchImages(id: String) : List<Thumbnails>{
        return imageDataSource.getImages(id)
    }
}