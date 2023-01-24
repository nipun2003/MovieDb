package com.nipunapps.moviedb.feature_auth.domain.model

data class RegistrationModel(
    val email : String = "",
    val password : String = "",
    val imageUri : String = "",
    val username : String = "",
    val bio : String = "",
    val age : Int = 18,
    val agreement : Boolean = false
)
