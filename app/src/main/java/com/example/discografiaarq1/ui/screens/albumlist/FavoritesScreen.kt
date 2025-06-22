package com.example.discografiaarq1.ui.screens.albumlist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.compose.material3.Text

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
    //vm: AlbumListScreenViewmodel = viewModel(),
    navController: NavHostController,
    onLogoutClick: () -> Unit)
{
    Text(text = "Lista de favoritos")

}