package com.dashdiet.app.data.model

data class User(
    val uid: String,
    val displayName: String?,
    val email: String?,
    val photoUrl: String?,
    val authProvider: AuthProvider
)

enum class AuthProvider {
    GOOGLE,
    APPLE,
    ANONYMOUS
}
