package com.example.discografiaarq1.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.discografiaarq1.ui.screens.albumdetail.AlbumDetailScreen
import com.example.discografiaarq1.ui.screens.favorites.FavoritesScreen
import com.example.discografiaarq1.ui.screens.login.LoginScreen
import com.example.discografiaarq1.ui.screens.splash.SplashScreen
import com.example.musicdiscography.AlbumListScreen

@Composable
fun NavigationStack(
    onGoogleLoginClick: () -> Unit,
    navController: NavHostController,
    onLogoutClick: () -> Unit
) {

        NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
            composable(route = Screens.Splash.route) {
                SplashScreen(navController = navController)
            }
            composable(route = Screens.Login.route) {
                LoginScreen(onGoogleLoginClick, navController = navController)
            }
            composable(route = Screens.AlbumList.route) {
                AlbumListScreen(navController = navController, onLogoutClick = onLogoutClick)
            }
            composable(route = Screens.AlbumDetail.route + "/{albumId}") { backStackEntry ->
                val albumId = backStackEntry.arguments?.getString("albumId") ?: ""
                AlbumDetailScreen(
                    albumId = albumId,
                )
            }
            composable(Screens.Favorites.route) {
                FavoritesScreen(navController = navController)
            }
        }
}
