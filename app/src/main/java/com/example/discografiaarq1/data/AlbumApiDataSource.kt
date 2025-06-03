package com.example.discografiaarq1.data

import android.util.Log
import Album
import emptyAlbum
import okio.IOException
import retrofit2.HttpException

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
        val response = RetrofitInstance.albumApi.getAlbum(albumId)
        Log.d(TAG, "albumes: ${response.id}")
        return response
    }

        // return RetrofitInstance.albumApi.getAlbumSearch(albumId).albums[0]
    }
