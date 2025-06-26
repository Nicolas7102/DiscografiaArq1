package com.example.discografiaarq1.data.localDb

import ArtistCredit
import Release
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "album")
data class AlbumLocalDb(
    @PrimaryKey val id: String = "",
    val title: String = "",
    val artistCreditJson: String? = null,
    val firstReleaseDate: String = "",
    var imageUrl: String? = null,
)