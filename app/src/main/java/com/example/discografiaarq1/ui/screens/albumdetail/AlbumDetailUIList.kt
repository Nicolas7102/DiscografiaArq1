//package com.example.musicdiscography
//
//import Album
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.foundation.lazy.items
//
//@Composable
//fun AlbumDetailUIList(
//    list: List<Album>,
//    modifier: Modifier = Modifier,
//    onClick: (String) -> Unit
//) {
//    LazyColumn (
//        modifier = modifier
//    ){
//        items(
//            items = list,
//            key = { it -> it.id }
//        ) {
//            album -> AlbumUIItem(album, onClick = onClick)
//        }
//    }
//}