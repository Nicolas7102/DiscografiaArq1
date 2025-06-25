package com.example.discografiaarq1.ui.screens.albumdetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.discografiaarq1.data.AlbumRepository
import com.example.discografiaarq1.domain.IAlbumRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AlbumDetailScreenViewmodel(
    private val albumRepository: IAlbumRepository = AlbumRepository(),
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance(),
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
) : ViewModel() {

    var uiState by mutableStateOf(AlbumDetailScreenState())
        private set

    private var fetchJob: Job? = null

    fun fetchAlbum() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            val album = albumRepository.fetchAlbum(uiState.albumId)
            uiState = uiState.copy(
                albumId = uiState.albumId,
                albumR = album
            )
            checkIfFavorite()
        }
    }

    fun setAlbumId(albumId: String) {
        uiState = uiState.copy(albumId = albumId)
        fetchAlbum()
    }

    private fun checkIfFavorite() {
        val userId = auth.currentUser?.uid ?: return
        val docRef = firestore.collection("favorites")
            .document(userId)
            .collection("albums")
            .document(uiState.albumId)

        docRef.get().addOnSuccessListener { document ->
            uiState = uiState.copy(isFavorite = document.exists())
        }
    }

    fun toggleFavorite() {
        val userId = auth.currentUser?.uid ?: return
        val docRef = firestore.collection("favorites")
            .document(userId)
            .collection("albums")
            .document(uiState.albumId)

        if (uiState.isFavorite) {
            docRef.delete().addOnSuccessListener {
                uiState = uiState.copy(isFavorite = false)
            }
        } else {
            val albumData = mapOf(
                "title" to uiState.albumR.title,
                "artist" to (uiState.albumR.artistCredit?.getOrNull(0)?.name ?: "Desconocido"),
                "releaseDate" to uiState.albumR.firstReleaseDate,
                "imageUrl" to uiState.albumR.imageUrl,
            )
            docRef.set(albumData).addOnSuccessListener {
                uiState = uiState.copy(isFavorite = true)
            }
        }
    }
}