package com.example.musicdiscography

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.discografiaarq1.ui.screens.Screens
import com.example.discografiaarq1.ui.screens.albumlist.AlbumListScreenViewmodel
import com.example.discografiaarq1.ui.theme.DiscografiaArq1Theme

@Composable
fun AlbumListScreen(
    modifier: Modifier = Modifier,
    vm: AlbumListScreenViewmodel = viewModel(),
    navController: NavHostController,
    onLogoutClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header con nombre de usuario y logout
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Hola ${vm.uiState.username}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )
            Button(onClick = onLogoutClick) {
                Text("Cerrar sesión")
            }
        }

        // Título
        Text(
            text = "Listado de Álbumes",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(top = 8.dp, bottom = 12.dp)
        )

        // Buscador
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = vm.uiState.searchQuery,
                onValueChange = { vm.updateSearchQuery(it) },
                label = { Text("Buscar álbum") },
                modifier = Modifier.weight(1f),
                singleLine = true
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { vm.fetchAlbums() }) {
                Text("Buscar")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { vm.toggleFavoritesView() },
            modifier = Modifier.fillMaxWidth()
        ) {

        Button(
            onClick = { navController.navigate(Screens.Favorites.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver Favoritos")
        }

        Spacer(modifier = Modifier.height(12.dp))

        AlbumUIList(
            list = vm.uiState.albumList,
            favorites = vm.uiState.favorites,
            modifier = Modifier.fillMaxSize(),
            onClick = { id -> navController.navigate(Screens.AlbumDetail.route + "/$id") },
            onFavoriteClick = { id -> vm.toggleFavorite(id) }
        )
    }
}
}
