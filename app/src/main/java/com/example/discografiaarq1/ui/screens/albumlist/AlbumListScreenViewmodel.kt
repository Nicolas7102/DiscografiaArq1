package com.example.discografiaarq1.ui.screens.albumlist

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.discografiaarq1.data.AlbumRepository
import com.example.discografiaarq1.domain.IAlbumRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class AlbumListScreenViewmodel(
    private val albumRepository: IAlbumRepository = AlbumRepository()
) : ViewModel()
{
    var uiState by mutableStateOf(AlbumListScreenState())
        private set

    private var fetchJob: Job? = null

    fun fetchAlbums() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                uiState = uiState.copy(albumList = albumRepository.fetchAlbums(uiState.searchQuery))
                uiState = uiState.copy(imageList = imageRepository.fetchImages(uiState.searchId))
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
