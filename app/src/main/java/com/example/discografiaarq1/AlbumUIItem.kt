package com.example.musicdiscography

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AlbumUIItem(
    album: Album,
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = album.id,
        )
        Text(
            text = album.title,
        )
    }
}