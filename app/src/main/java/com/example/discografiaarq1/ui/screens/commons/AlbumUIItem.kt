package com.example.musicdiscography

import android.R.attr.onClick
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import Album
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import com.example.discografiaarq1.data.image.Images
import coil.compose.AsyncImage

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
        ) 
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
