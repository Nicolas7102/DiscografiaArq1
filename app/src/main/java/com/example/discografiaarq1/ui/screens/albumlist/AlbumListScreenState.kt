package com.example.discografiaarq1.ui.screens.albumlist

import com.example.musicdiscography.Album

data class AlbumListScreenState (
    val albumList: List<Album> = emptyList(),
    val searchQuery: String = ""
)