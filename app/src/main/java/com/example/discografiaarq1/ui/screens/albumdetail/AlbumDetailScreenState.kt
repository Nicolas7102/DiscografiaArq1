package com.example.discografiaarq1.ui.screens.albumdetail

import Album
import emptyAlbum

data class AlbumDetailScreenState(
    val albumId: String = "",
    val albumDetail: Album = emptyAlbum(),
)