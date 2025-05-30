package com.example.discografiaarq1.data

import com.example.discografiaarq1.domain.IAlbumRepository
import com.example.musicdiscography.Album

class AlbumRepository (val albumDataSource: IAlbumDataSource = AlbumTestDataSource()) : IAlbumRepository {
    override suspend fun fetchAlbums() : List<Album>{
        return albumDataSource.getAlbums()
    }
}