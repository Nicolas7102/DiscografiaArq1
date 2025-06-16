package com.example.discografiaarq1.ui.screens.albumlist

import Album

data class AlbumListScreenState (
    val username: String = "Username",
    val albumList: List<Album> = emptyList(),
    val searchQuery: String = "",
    val searchImage: String = ""
)