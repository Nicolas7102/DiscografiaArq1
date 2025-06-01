package com.example.discografiaarq1.ui.screens.albumlist

import Album
import com.example.discografiaarq1.data.image.Thumbnails

data class AlbumListScreenState (
    val albumList: List<Album> = emptyList(),
    val searchQuery: String = "",
    val imageList: List<Thumbnails> = emptyList()
)