package com.example.discografiaarq1.data

import Album

interface IAlbumDataSource {
    suspend fun getAlbums(search: String) : List<Album>
    suspend fun getAlbumById(albumId: String) : Album
    suspend fun getFavorites() : List<Album>
}