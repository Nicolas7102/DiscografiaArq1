package com.example.discografiaarq1.ui.screens.albumdetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.discografiaarq1.data.AlbumRepository
import com.example.discografiaarq1.domain.IAlbumRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AlbumDetailScreenViewmodel(
    private val albumRepository: IAlbumRepository = AlbumRepository()
) : ViewModel(){
    var uiState by mutableStateOf(AlbumDetailScreenState())
    private set

    private var fetchJob: Job? = null

    fun fetchAlbum() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            val album = albumRepository.fetchAlbum(uiState.albumId)
            //val tracks = albumRepository.fetchTracks(uiState.albumId)
            uiState = uiState.copy(
                albumId = uiState.albumId,
                albumR = albumRepository.fetchAlbum(uiState.albumId)
            )
        }
    }

    fun setAlbumId(albumId: String): Unit {
        uiState = uiState.copy(albumId = albumId, albumR = uiState.albumR)
        fetchAlbum()
    }
}