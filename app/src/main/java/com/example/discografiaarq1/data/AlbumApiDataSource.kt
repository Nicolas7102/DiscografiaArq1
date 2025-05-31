package com.example.discografiaarq1.data

import android.icu.text.StringSearch
import android.util.Log
import com.example.musicdiscography.Album
import okhttp3.OkHttpClient
import okio.IOException
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
}