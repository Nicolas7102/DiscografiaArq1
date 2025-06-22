package com.example.discografiaarq1.domain

import Album

interface IAlbumRepository {
    suspend fun fetchAlbums(search: String) : List<Album>
    suspend fun fetchAlbum(albumId: String) : Album
    suspend fun fetchFavorites(): List<Album>
}