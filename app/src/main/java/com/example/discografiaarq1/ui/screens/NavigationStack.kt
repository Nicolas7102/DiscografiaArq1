package com.example.discografiaarq1.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.discografiaarq1.ui.screens.albumdetail.AlbumDetailScreen
import com.example.discografiaarq1.ui.screens.splash.SplashScreen
import com.example.musicdiscography.AlbumListScreen

@Composable
fun NavigationStack() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screens.AlbumList.route) {
            AlbumListScreen(navController = navController)
        }
        composable(route = Screens.AlbumDetail.route + "/{albumId}") {
            it ->
            var albumId = it.arguments?.getString("albumId")
            AlbumDetailScreen(albumId ?: "")
        }
    }
}