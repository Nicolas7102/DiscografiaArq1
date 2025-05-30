package com.example.discografiaarq1.domain

import com.example.musicdiscography.Album

interface IAlbumRepository {
    suspend fun fetchAlbums() : List<Album>
}