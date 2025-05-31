package com.example.musicdiscography

import com.google.gson.annotations.SerializedName

data class AlbumResponse(
    @SerializedName("release-groups")
    val albums: List<Album>
)

data class Album(
    val id: String,
    val title: String,
    @SerializedName("artist-credit")
    val artistCredit: List<ArtistCredit>
)

data class ArtistCredit(
    val name: String,
)

fun emptyAlbum() : Album {
    return Album("", "", emptyList())
}