package com.example.discografiaarq1.ui.screens.albumdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import Album

@Composable
fun AlbumUiItemDetail(
    album: Album
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = album.title,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Lanzamiento: ${album.firstReleaseDate}",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Artista: ${album.artistCredit?.getOrNull(0)?.name ?: "Desconocido"}",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
