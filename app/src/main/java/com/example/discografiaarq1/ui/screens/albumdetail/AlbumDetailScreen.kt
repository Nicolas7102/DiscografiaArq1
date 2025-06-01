package com.example.discografiaarq1.ui.screens.albumdetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import com.example.musicdiscography.AlbumDetailUIList

@Composable
fun AlbumDetailScreen(
    albumId: String,
    modifier: Modifier = Modifier,
    vm: AlbumDetailScreenViewmodel = viewModel(),
) {
    vm.setAlbumId(albumId)

    if (vm.uiState.albumDetail.id == "") {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    } else {
        AlbumUiItemDetail(vm.uiState.albumDetail)
    }
}