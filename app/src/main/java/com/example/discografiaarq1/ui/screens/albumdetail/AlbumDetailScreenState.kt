package com.example.discografiaarq1.ui.screens.albumdetail

import Album
import AlbumDetailResponse
import Tracks
import emptyAlbum

data class AlbumDetailScreenState(
    val albumId: String = "",
    val albumR: Album = emptyAlbum(),
    val tracks: Tracks = Tracks(emptyList())
)