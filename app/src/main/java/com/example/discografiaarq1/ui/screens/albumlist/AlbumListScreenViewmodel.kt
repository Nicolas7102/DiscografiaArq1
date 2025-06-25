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
import com.google.firebase.auth.FirebaseAuth
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

    init {
        getUserName()
    }

    private var fetchJob: Job? = null

    fun fetchAlbums() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val albums = albumRepository.fetchAlbums(uiState.searchQuery)

                albums.forEach { album ->
                    val imgUrl = imageRepository.fetchImages(album.id)
                    album.imageUrl = imgUrl
                }

                uiState = uiState.copy(albumList = albums, searchQuery = uiState.searchQuery, username = uiState.username)
            }
            catch (e: IOException) {
                Log.e("AlbumApp", "Error recuperando la lista de albumes")
            }
        }
    }

    fun updateSearchQuery(search: String) {
        uiState = uiState.copy(searchQuery = search, albumList = uiState.albumList, username = uiState.username)
    }

    fun getUserName() {
        uiState= uiState.copy(searchQuery = uiState.searchQuery, albumList = uiState.albumList, username = "${FirebaseAuth.getInstance().currentUser?.displayName ?: "Usuario Desconocido"} ") // (${FirebaseAuth.getInstance().currentUser?.email ?: "email"})")
    }

}
