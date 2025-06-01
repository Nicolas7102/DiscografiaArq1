package com.example.discografiaarq1.data.image

import android.util.Log
import com.example.discografiaarq1.data.RetrofitInstance
import com.example.musicdiscography.Album
import okio.IOException
import retrofit2.HttpException

class ImageApiDataSource : IImageDataSource{
    private val TAG = "DiscographyApp"

    override suspend fun getImages(id: String): List<Thumbnails> {
        Log.d(TAG, "ImageApiDataSource.getImages()")

        return try{
            Log.d(TAG, "AlbumApiDataSource.getAlbums Search: $id")
            //var suffix = "\""
            //var query = prefix + search + suffix
            val imageResponse = RetrofitInstanceImage.imageApi.getImageSearch(id)
            //Log.d(TAG, "AlbumApiDataSource.getAlbums Result: ${albumResponse.albums.size}")
            return imageResponse.images[0].thumbnails
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
    override suspend fun getImageById(imageId: String): Thumbnails {
        return RetrofitInstanceImage.imageApi.getImageSearch(imageId).images[0].thumbnails[0]
    }
}