package com.example.discografiaarq1.ui.screens.favorites

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel

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

    LazyColumn {
        items(state.favorites) {album ->

        }
    }


}