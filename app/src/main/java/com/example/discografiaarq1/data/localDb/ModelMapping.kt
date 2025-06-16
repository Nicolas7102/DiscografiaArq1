package com.example.discografiaarq1.data.localDb

import Album
import Release

fun Album.toLocal() = AlbumLocalDb(
    id,
    title,
    artistCredit, // Arreglar para la lista
    firstReleaseDate,
    imageUrl
)

fun AlbumLocalDb.toExternal() = Album(
    id,
    title,
    artistCredit, // Arreglar para la lista
    firstReleaseDate,
    imageUrl as List<Release>? //Arreglar
)

fun List<AlbumLocalDb>.localToExternal() = map(AlbumLocalDb::toExternal)