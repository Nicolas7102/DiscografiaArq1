package com.example.discografiaarq1.data.localDb

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@Database(entities = [AlbumLocalDb::class], version = 1, exportSchema = false)
abstract class AlbumDb : RoomDatabase() {
    abstract fun albumDao(): IAlbumDao

    companion object {
        //private const val DATABASE_NAME = "album_db"

        @Volatile
        private var INSTANCE: AlbumDb? = null

        fun getInstance(context: Context): AlbumDb = INSTANCE ?: synchronized(this){
            INSTANCE ?: buildDatabase(context)
        }

        private fun buildDatabase(context: Context): AlbumDb = Room.databaseBuilder(
            context,
            AlbumDb::class.java,
            "album_db")
            .fallbackToDestructiveMigration()
            .build()

        suspend fun clean(context: Context) = coroutineScope {
            launch(Dispatchers.IO) {
                getInstance(context).clearAllTables()
            }
        }
    }
}