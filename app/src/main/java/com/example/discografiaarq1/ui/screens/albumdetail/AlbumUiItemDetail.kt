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
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.IconButton
import androidx.compose.material3.SegmentedButtonDefaults.Icon

@Composable
fun AlbumUiItemDetail(
    album: Album,
    onFavoriteClick: (Album) -> Unit,
    isFavorite: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        IconButton(
            onClick = { onFavoriteClick(album) },
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            androidx.compose.material3.Icon(
                imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                contentDescription = if (isFavorite) "Eliminar de favoritos" else "Agregar a favoritos",
                tint = MaterialTheme.colorScheme.primary
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 56.dp),
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
}