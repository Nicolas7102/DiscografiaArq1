package com.example.discografiaarq1.ui.screens.favorites

import Album

data class FavoritesScreenState (
    val username: String = "Username",
    val favorites: List<Album> = emptyList()
)