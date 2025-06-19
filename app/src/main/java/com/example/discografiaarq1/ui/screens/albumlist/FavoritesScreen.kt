package com.example.discografiaarq1.ui.screens.albumlist

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.discografiaarq1.ui.screens.Screens
import com.example.musicdiscography.AlbumUIList

@Composable
fun FavoritesScreen(
    vm: AlbumListScreenViewmodel = viewModel(),
    navController: NavHostController
) {
    // Llama a la carga de favoritos al entrar a la pantalla
    LaunchedEffect(Unit) {
        vm.fetchFavoriteAlbums()
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Álbumes Favoritos",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        val favoriteAlbums = vm.uiState.albumList
            .filter { it.id.isNotBlank() && vm.uiState.favorites.contains(it.id) }

        if (favoriteAlbums.isEmpty()) {
            Text("No tienes álbumes favoritos aún.", style = MaterialTheme.typography.bodyMedium)
        } else {
            AlbumUIList(
                list = favoriteAlbums,
                favorites = vm.uiState.favorites,
                modifier = Modifier.fillMaxSize(),
                onClick = { id -> navController.navigate(Screens.AlbumDetail.route + "/$id") },
                onFavoriteClick = { id -> vm.toggleFavorite(id) }
            )
        }
    }
}
