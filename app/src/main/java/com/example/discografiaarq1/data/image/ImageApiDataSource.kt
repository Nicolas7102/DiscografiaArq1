package com.example.discografiaarq1.data.image

import android.util.Log
import com.example.discografiaarq1.data.RetrofitInstance
import Album
import okio.IOException
import retrofit2.HttpException

class ImageApiDataSource : IImageDataSource{
    private val TAG = "DiscographyApp"

    override suspend fun getImages(id: String): String {
        Log.d(TAG, "ImageApiDataSource.getImages()")

        return try{
            val imageResponse = RetrofitInstanceImage.imageApi.getImageSearch(id)
            return imageResponse.images[0].image
        } catch (e: HttpException) {
            Log.e(TAG, "HTTP Error: ${e.code()}: ${e.message()}")
            ""
        }
        catch (e: IOException) {
            Log.e(TAG, "Network Error: ${e.localizedMessage}")
            ""
        }

        catch (e: Exception) {
            Log.e(TAG, "Unknown error: ${e.localizedMessage}")
            ""
        }
    }
    override suspend fun getImageById(imageId: String): String {
//        return RetrofitInstanceImage.imageApi.getImageSearch(imageId).images[0].thumbnails[0]
        return RetrofitInstanceImage.imageApi.getImageSearch(imageId).images[0].image
    }
}