package com.example.discografiaarq1.data

import com.example.discografiaarq1.domain.IAlbumRepository
import com.example.musicdiscography.Album

class AlbumRepository (val albumDataSource: IAlbumDataSource = AlbumApiDataSource())
    : IAlbumRepository
{
    override suspend fun fetchAlbums(search: String) : List<Album>{
        return albumDataSource.getAlbums(search)
    }

    override suspend fun fetchAlbum(albumId: String) : Album{
        return albumDataSource.getAlbumById(albumId)
    }
}