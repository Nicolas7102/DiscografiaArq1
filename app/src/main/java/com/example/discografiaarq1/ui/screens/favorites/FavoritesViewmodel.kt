package com.example.discografiaarq1.ui.screens.favorites

import Album
import ArtistCredit
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FavoritesViewModel : ViewModel() {
    private val firestore = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    var favoriteAlbums by mutableStateOf(listOf<Album>())
        private set

    init {
        fetchFavorites()
    }

    fun fetchFavorites() {
        val userId = auth.currentUser?.uid ?: return
        firestore.collection("favorites")
            .document(userId)
            .collection("albums")
            .get()
            .addOnSuccessListener { result ->
                val albums = result.mapNotNull { doc ->
                    val title = doc.getString("title") ?: return@mapNotNull null
                    val artist = doc.getString("artist")
                    val id = doc.id
                    Album(
                        id = id,
                        title = title,
                        artistCredit = listOf(ArtistCredit(name = artist ?: "Desconocido"))
                    )
                }
                favoriteAlbums = albums
            }
    }
}
