package com.example.discografiaarq1.ui.screens.albumlist

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.discografiaarq1.data.AlbumRepository
import com.example.discografiaarq1.data.image.IImageRepository
import com.example.discografiaarq1.data.image.ImageApiDataSource
import com.example.discografiaarq1.data.image.ImageRepository
import com.example.discografiaarq1.domain.IAlbumRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class AlbumListScreenViewmodel(
    private val albumRepository: IAlbumRepository = AlbumRepository(),
    private val imageRepository: IImageRepository = ImageRepository()
) : ViewModel()
{
    var uiState by mutableStateOf(AlbumListScreenState())
        private set

    private var fetchJob: Job? = null

    fun fetchAlbums() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val albums = albumRepository.fetchAlbums(uiState.searchQuery)

//                val albumWithImage = albums.map { album ->
//                    Log.d("AlbumApp", "album.id: ${album.id}")
//                    val releaseId = album.releases.firstOrNull()?.id
//                    val imageUrl = imageRepository.fetchImages(album.id)
//                    Log.d("AlbumApp", "imageUrl: $imageUrl")
//                    //album.copy(imageUrl = imageUrl)
//                    album.imageUrl = imageUrl

                albums.forEach { album ->
                    val imgUrl = imageRepository.fetchImages(album.id)
                    album.imageUrl = imgUrl
                }

                uiState = uiState.copy(albumList = albums)
            }
            catch (e: IOException) {
                Log.e("AlbumApp", "Error recuperando la lista de albumes :(")
            }
        }
    }

    fun updateSearchQuery(search: String) {
        uiState = uiState.copy(searchQuery = search, albumList = uiState.albumList)
    }

}
