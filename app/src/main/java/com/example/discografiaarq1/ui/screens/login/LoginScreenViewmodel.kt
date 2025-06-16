package com.example.discografiaarq1.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.discografiaarq1.ui.screens.Screens
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow


class LoginScreenViewmodel: ViewModel() {
    private val _uiEvent = Channel<String>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        checkAuthStatus()
    }

    fun checkAuthStatus() {
        if (FirebaseAuth.getInstance().currentUser != null) {
            viewModelScope.launch {
                _uiEvent.send("loginOK")
            }
        }
    }
}