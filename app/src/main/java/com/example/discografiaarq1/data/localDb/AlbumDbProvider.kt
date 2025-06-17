package com.example.discografiaarq1.data.localDb

import android.content.Context

object AlbumDbProvider {
    lateinit var dbLocal: AlbumDb
        private set

    fun createDb(context: Context) {
        dbLocal = AlbumDb.getInstance(context)
    }
}