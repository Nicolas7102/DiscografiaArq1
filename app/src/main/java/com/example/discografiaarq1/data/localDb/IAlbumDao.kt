package com.example.discografiaarq1.data.localDb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IAlbumDao {
    @Query("SELECT * FROM album")
    suspend fun getAlbums(): List<AlbumLocalDb>

    @Query("SELECT * FROM album WHERE id = :id LIMIT 1")
    suspend fun findById(id: String): AlbumLocalDb?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg album: AlbumLocalDb)

    @Delete
    suspend fun delete(album: AlbumLocalDb)

}