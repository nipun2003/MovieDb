package com.nipunapps.moviedb.feature_auth.domain.model

data class UserModel(
    val name: String = "",
    val username: String = "",
    val email: String = "",
    val age: Int = 18,
    val id: String = "",
    val bio: String = "",
    val agreement: Boolean = false,
    val imageUri : String = ""
)
