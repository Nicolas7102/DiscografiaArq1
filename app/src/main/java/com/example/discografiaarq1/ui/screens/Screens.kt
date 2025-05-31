package com.example.discografiaarq1.ui.screens

sealed class Screens(val route: String) {
    object Splash: Screens("splash")
    object AlbumList: Screens("album_list_screen")
    object AlbumDetail: Screens("album_detail_screen")

}