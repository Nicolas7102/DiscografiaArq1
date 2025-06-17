package com.example.musicdiscography

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import Album
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage //TODO CAMBIAR POR GLIDE

@Composable
fun AlbumCover(url: String) {
    AsyncImage(
        model = url,
        contentDescription = "Album cover",
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun AlbumUIItem(
    album: Album,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    Card(
        modifier = modifier
            .padding(12.dp)
            .fillMaxWidth()
            .clickable {
                onClick(album.id)
            },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AlbumCover(url = album.imageUrl ?: "")

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = album.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Artista: ${album.artistCredit?.getOrNull(0)?.name ?: "Desconocido"}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
