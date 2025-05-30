package com.example.discografiaarq1.ui.screens.albumlist

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.discografiaarq1.data.AlbumRepository
import com.example.discografiaarq1.data.AlbumTestDataSource
import com.example.discografiaarq1.domain.IAlbumRepository
import com.example.musicdiscography.Album
import com.example.musicdiscography.AlbumResponse
import com.google.gson.Gson
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class AlbumListScreenViewmodel(
    private val albumRepository: IAlbumRepository = AlbumRepository()
) : ViewModel()
{
    val repo = AlbumRepository(AlbumTestDataSource())

    var uiState by mutableStateOf(AlbumListScreenState())
        private set

    init {
        fetchAlbums()
    }

    private var fetchJob: Job? = null

    fun fetchAlbums() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                uiState = uiState.copy(albumList = albumRepository.fetchAlbums())
            }
            catch (e: IOException) {
                Log.e("AlbumApp", "Error recuperando la lista de albumes :(")
            }
        }
    }
}
