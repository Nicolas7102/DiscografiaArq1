package com.example.discografiaarq1.ui.screens.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.discografiaarq1.ui.screens.Screens
import com.example.musicdiscography.AlbumUIList

@Composable
fun FavoritesScreen(
    navController: NavHostController,
    vm: FavoritesViewModel = viewModel()
) {
    val favoriteAlbums = vm.favoriteAlbums

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Albumes favoritos",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (favoriteAlbums.isEmpty()) {
            Text("No hay álbumes favoritos.")
        } else {
            AlbumUIList(
                list = favoriteAlbums,
                modifier = Modifier.fillMaxSize(),
                onClick = { id ->
                    navController.navigate(Screens.AlbumDetail.route + "/${id}")
                }
            )
        }
    }
}
