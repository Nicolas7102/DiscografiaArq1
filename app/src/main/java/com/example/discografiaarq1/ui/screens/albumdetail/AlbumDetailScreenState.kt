package com.example.discografiaarq1.ui.screens.albumdetail

import com.example.musicdiscography.Album
import com.example.musicdiscography.emptyAlbum

data class AlbumDetailScreenState(val albumId: String, val albumDetail: Album = emptyAlbum())