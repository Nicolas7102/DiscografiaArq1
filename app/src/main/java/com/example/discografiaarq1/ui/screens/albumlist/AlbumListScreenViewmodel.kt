package com.example.discografiaarq1.ui.screens.albumlist

import Album
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
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.io.IOException


class AlbumListScreenViewmodel(
    private val albumRepository: IAlbumRepository = AlbumRepository(),
    private val imageRepository: IImageRepository = ImageRepository()
) : ViewModel()
{
    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    var uiState by mutableStateOf(AlbumListScreenState())
        private set

    var showFavoritesOnly by mutableStateOf(false)
        private set

    init {
        getUserName()
        loadFavorites()
    }

    private fun getCurrentUserId(): String? {
        return auth.currentUser?.uid
    }

    private fun loadFavorites() {
        val userId = getCurrentUserId() ?: return

        db.collection("users").document(userId)
            .collection("favorites")
            .get()
            .addOnSuccessListener { result ->
                val favIds = result.documents.map { it.id }.toSet()
                uiState = uiState.copy(favorites = favIds)
            }
            .addOnFailureListener {
                Log.e("AlbumApp", "Error cargando favoritos: ${it.message}")
            }
    }

    fun toggleFavorite(album: Album) {
        val userId = auth.currentUser?.uid ?: return
        val favorites = uiState.favorites.toMutableSet()

        val favoriteRef = db.collection("users").document(userId)
            .collection("favorites").document(album.id)

        if (favorites.contains(album.id)) {
            favorites.remove(album.id)
            favoriteRef.delete()
                .addOnFailureListener { e ->
                    Log.e("AlbumApp", "Error eliminando favorito: ${e.message}")
                }
        } else {
            favorites.add(album.id)
            // Guardar el álbum completo en Firestore
            favoriteRef.set(album)
                .addOnFailureListener { e ->
                    Log.e("AlbumApp", "Error guardando favorito: ${e.message}")
                }
        }

        uiState = uiState.copy(favorites = favorites)
    }

    fun toggleFavoritesView() {
        showFavoritesOnly = !showFavoritesOnly
        if (showFavoritesOnly) {
            val favoriteAlbums = uiState.albumList.filter { uiState.favorites.contains(it.id) }
            uiState = uiState.copy(albumList = favoriteAlbums)
        } else {
            fetchAlbums()
        }
    }

    fun fetchFavoriteAlbums() {
        val userId = FirebaseAuth.getInstance().currentUser?.uid ?: return

        viewModelScope.launch {
            try {
                val favDocs = db.collection("users")
                    .document(userId)
                    .collection("favorites")
                    .get()
                    .await()

                val albums = favDocs.mapNotNull { it.toObject(Album::class.java) }

                // Si querés actualizar las imágenes:
                albums.forEach { album ->
                    album.imageUrl = imageRepository.fetchImages(album.id)
                }

                uiState = uiState.copy(albumList = albums)
            } catch (e: Exception) {
                Log.e("AlbumApp", "Error recuperando favoritos: ${e.localizedMessage}")
            }
        }
    }

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

                uiState = uiState.copy(albumList = albums, searchQuery = uiState.searchQuery, username = uiState.username)
            }
            catch (e: IOException) {
                Log.e("AlbumApp", "Error recuperando la lista de albumes :(")
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
