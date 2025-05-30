package com.example.musicdiscography

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.discografiaarq1.ui.screens.albumlist.AlbumListScreenViewmodel
import com.example.discografiaarq1.ui.theme.DiscografiaArq1Theme

@Composable
fun AlbumListScreen(modifier: Modifier = Modifier, vm: AlbumListScreenViewmodel = viewModel()) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            text = "Listado de algo",
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(12.dp))
        AlbumUIList(vm.uiState.albumList, Modifier.fillMaxSize())
    }

}

@Preview(showBackground = true)
@Composable
fun AlbumListScreenPreview() {
    DiscografiaArq1Theme {
        //MusicDiscographyScreen(List<Album>())
    }
}