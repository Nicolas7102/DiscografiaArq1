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
    favorites: Set<String>,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit,
    onFavoriteClick: (Album) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(list, key = { it.id }) { album ->
            AlbumUIItem(
                album = album,
                isFavorite = favorites.contains(album.id),
                onFavoriteClick = onFavoriteClick,
                onClick = onClick
            )
        }
    }
}