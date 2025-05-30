package com.example.discografiaarq1.data

import com.example.musicdiscography.Album

interface IAlbumDataSource {
    suspend fun getAlbums() : List<Album>
}