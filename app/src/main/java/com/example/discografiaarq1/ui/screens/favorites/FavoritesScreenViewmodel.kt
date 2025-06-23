package com.example.discografiaarq1.ui.screens.favorites

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.discografiaarq1.data.AlbumRepository
import com.example.discografiaarq1.domain.IAlbumRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FavoritesScreenViewmodel(
    private val albumRepository: IAlbumRepository = AlbumRepository()
): ViewModel() {

    var uiState by mutableStateOf(FavoritesScreenState())
        private set

    private var fetchJob: Job? = null

    init {
        getUserName()
    }

    fun fetchFavorites() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            val favorites = albumRepository.fetchFavorites()
            uiState = uiState.copy(favorites = favorites)

        }
    }

    fun getUserName() {
        uiState= uiState.copy(username = "${FirebaseAuth.getInstance().currentUser?.displayName ?: "Usuario Desconocido"} ")
    }
}