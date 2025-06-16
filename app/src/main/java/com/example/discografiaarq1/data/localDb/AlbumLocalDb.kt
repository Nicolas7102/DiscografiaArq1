package com.example.discografiaarq1.data.localDb

import ArtistCredit
import Release
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "album")
data class AlbumLocalDb(
    val id: String = "",
    val title: String = "",
    @SerializedName("artist-credit")
    val artistCredit: List<ArtistCredit>? = null,
    @SerializedName("first-release-date")
    val firstReleaseDate: String = "",
    var imageUrl: String? = null,
)