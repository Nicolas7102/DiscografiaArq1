package com.example.discografiaarq1.data.localDb

import Album
import ArtistCredit
import Release
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


fun Album.toLocal(): AlbumLocalDb {
    val gson = Gson()
    val json = gson.toJson(artistCredit)
    return AlbumLocalDb(
        id = id,
        title = title,
        artistCreditJson = json,
        firstReleaseDate = firstReleaseDate,
        imageUrl = imageUrl
    )
}

fun AlbumLocalDb.toExternal(): Album {
    val gson = Gson()
    val type = object : TypeToken<List<ArtistCredit>>() {}.type
    val artistCreditList = if (artistCreditJson == null) null else gson.fromJson<List<ArtistCredit>>(artistCreditJson, type)
    return Album(
        id = id,
        title = title,
        artistCredit = artistCreditList,
        firstReleaseDate = firstReleaseDate,
        imageUrl = imageUrl
    )
}

fun List<AlbumLocalDb>.localToExternal() = map(AlbumLocalDb::toExternal)