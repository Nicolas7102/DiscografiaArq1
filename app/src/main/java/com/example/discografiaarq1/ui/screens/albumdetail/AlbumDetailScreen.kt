package com.example.discografiaarq1.ui.screens.albumdetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun AlbumDetailScreen(
    albumId: String,
    modifier: Modifier = Modifier,
    vm: AlbumDetailScreenViewmodel = viewModel(),
) {
    vm.setAlbumId(albumId)

    if (vm.uiState.albumR.id == "") {
        Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    } else {
        AlbumUiItemDetail(vm.uiState.albumR, onFavoriteClick = { vm.toggleFavorite() }, isFavorite = vm.uiState.isFavorite)
        }
    }
