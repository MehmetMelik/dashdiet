package com.dashdiet.app.ui.screens.auth

import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dashdiet.app.data.model.AuthProvider
import com.dashdiet.app.data.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.OAuthProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AuthUiState(
    val isLoading: Boolean = false,
    val isSignedIn: Boolean = false,
    val user: User? = null,
    val error: String? = null
)

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    init {
        checkCurrentUser()
    }

    private fun checkCurrentUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null) {
            _uiState.value = AuthUiState(
                isSignedIn = true,
                user = User(
                    uid = firebaseUser.uid,
                    displayName = firebaseUser.displayName,
                    email = firebaseUser.email,
                    photoUrl = firebaseUser.photoUrl?.toString(),
                    authProvider = AuthProvider.GOOGLE
                )
            )
        }
    }

    fun handleGoogleSignInResult(idToken: String?) {
        if (idToken == null) {
            _uiState.value = _uiState.value.copy(isLoading = false, error = "Google sign-in failed")
            return
        }

        _uiState.value = _uiState.value.copy(isLoading = true, error = null)

        val credential = GoogleAuthProvider.getCredential(idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnSuccessListener { authResult ->
                val firebaseUser = authResult.user
                _uiState.value = AuthUiState(
                    isSignedIn = true,
                    user = firebaseUser?.let {
                        User(
                            uid = it.uid,
                            displayName = it.displayName,
                            email = it.email,
                            photoUrl = it.photoUrl?.toString(),
                            authProvider = AuthProvider.GOOGLE
                        )
                    }
                )
            }
            .addOnFailureListener { exception ->
                _uiState.value = AuthUiState(error = exception.message)
            }
    }

    fun handleAppleSignIn(activity: android.app.Activity) {
        _uiState.value = _uiState.value.copy(isLoading = true, error = null)

        val provider = OAuthProvider.newBuilder("apple.com")
        provider.addCustomParameter("locale", "en")

        firebaseAuth.startActivityForSignInWithProvider(activity, provider.build())
            .addOnSuccessListener { authResult ->
                val firebaseUser = authResult.user
                _uiState.value = AuthUiState(
                    isSignedIn = true,
                    user = firebaseUser?.let {
                        User(
                            uid = it.uid,
                            displayName = it.displayName,
                            email = it.email,
                            photoUrl = it.photoUrl?.toString(),
                            authProvider = AuthProvider.APPLE
                        )
                    }
                )
            }
            .addOnFailureListener { exception ->
                _uiState.value = AuthUiState(error = exception.message)
            }
    }

    fun continueAsGuest() {
        _uiState.value = AuthUiState(
            isSignedIn = true,
            user = User(
                uid = "guest",
                displayName = null,
                email = null,
                photoUrl = null,
                authProvider = AuthProvider.ANONYMOUS
            )
        )
    }

    fun setLoading() {
        _uiState.value = _uiState.value.copy(isLoading = true, error = null)
    }

    fun signOut() {
        firebaseAuth.signOut()
        _uiState.value = AuthUiState()
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}
