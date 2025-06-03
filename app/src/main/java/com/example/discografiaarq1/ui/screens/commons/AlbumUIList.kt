package com.example.musicdiscography

import Album
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.systemBars
import androidx.compose.ui.unit.dp

@Composable
fun AlbumUIList(
    list: List<Album>,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .padding(WindowInsets.systemBars.asPaddingValues()) // <-- Avoid system bars
    ) {
        items(
            items = list,
            key = { it.id }
        ) { album ->
            AlbumUIItem(album, onClick = onClick)
        }
    }
}
