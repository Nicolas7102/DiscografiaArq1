package com.example.discografiaarq1.ui.screens.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musicdiscography.AlbumListScreen
import com.example.musicdiscography.AlbumUIItem
import com.example.musicdiscography.AlbumUIList

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
    vm: FavoritesScreenViewmodel = viewModel(),
    navController: NavHostController,
    onLogoutClick: () -> Unit)
{
    Text(text = "Lista de favoritos")

    val state = vm.uiState

    LaunchedEffect(Unit) {
        vm.fetchFavorites()
    }

    if (state.favorites.isEmpty()) {
        Text(
            text = "No hay álbumes favoritos.",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )
    } else {
        AlbumUIList(
            list = state.favorites,
            onClick = { albumId ->
                navController.navigate("albumDetail/$albumId")
            }
        )
    }
}