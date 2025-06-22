package com.example.discografiaarq1.data

import android.util.Log
import Album
import com.example.discografiaarq1.data.localDb.AlbumDb
import com.example.discografiaarq1.data.localDb.AlbumDbProvider
import com.example.discografiaarq1.data.localDb.toExternal
import com.example.discografiaarq1.data.localDb.toLocal
import emptyAlbum
import okio.IOException
import retrofit2.HttpException
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await


class AlbumApiDataSource : IAlbumDataSource{
    private val TAG = "DiscographyApp"

    override suspend fun getAlbums(search: String): List<Album> {
        Log.d(TAG, "AlbumApiDataSource.getAlbums()")

        return try{
            Log.d(TAG, "AlbumApiDataSource.getAlbums Search: $search")
            var prefix = "release:\""
            var suffix = "\""
            var query = prefix + search + suffix
            val albumResponse = RetrofitInstance.albumApi.getAlbumSearch(query)
            Log.d(TAG, "AlbumApiDataSource.getAlbums Result: ${albumResponse.albums.size}")
            return albumResponse.albums
        } catch (e: HttpException) {
            Log.e(TAG, "HTTP Error: ${e.code()}: ${e.message()}")
            emptyList()
        }
        catch (e: IOException) {
            Log.e(TAG, "Network Error: ${e.localizedMessage}")
            emptyList()
        }

        catch (e: Exception) {
            Log.e(TAG, "Unknown error: ${e.localizedMessage}")
            emptyList()
        }
    }

    override suspend fun getAlbumById(albumId: String): Album {
        Log.d("ALBUM_DB", "getAlbumById()")

        val db = FirebaseFirestore.getInstance()
        val dbLocal = AlbumDbProvider.dbLocal

        var albumLocal = dbLocal.albumDao().findById(albumId)
        if (albumLocal != null) {
            Log.d("ALBUM_DB", "ENCONTRADO EN LOCAL")
            return albumLocal.toExternal()
        } else {

        var albumRes = db.collection("Favoritos").document(albumId).get().await()
        var album = albumRes.toObject(Album::class.java)
        if (album != null) {
            Log.d("ALBUM_DB", "ENCONTRADO EN FIRESTORE")

            val albumLocal = album.toLocal()
            dbLocal.albumDao().insert(albumLocal)

            return album
        } else {
            Log.d("ALBUM_DB", "NO ENCONTRADO EN FIRESTORE")
            album = RetrofitInstance.albumApi.getAlbum(albumId)
            db.collection("Favoritos").document(albumId).set(album)

            val albumLocal = album.toLocal()
            dbLocal.albumDao().insert(albumLocal)

            return album
        }

        //val response = RetrofitInstance.albumApi.getAlbum(albumId)
        //Log.d(TAG, "albumes: ${response.id}")
        //return response
    }
    }

    override suspend fun getFavorites(): List<Album>{
        val db = FirebaseFirestore.getInstance()

        return try{
            val albumResponse = db.collection("Favoritos").get().await()
            albumResponse.documents.mapNotNull { doc -> doc.toObject(Album::class.java) }
        } catch (e: Exception) {
            Log.w("ALBUM_DB", "Error getting documents.", e)
            emptyList()
        }

//        db.collection("Favoritos").get().addOnSuccessListener { result ->
//            for (document in result) {
//                Log.d("ALBUM_DB", "${document.id} => ${document.data}")
//            }
//        }
//        .addOnFailureListener { exception ->
//            Log.w("ALBUM_DB", "Error getting documents.", exception)
//        }.await()
    }
}