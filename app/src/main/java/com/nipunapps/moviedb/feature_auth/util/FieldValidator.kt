package com.nipunapps.moviedb.feature_auth.util

object FieldValidator {

    @Throws(FieldNotValidException::class)
    fun validateEmailAndPassword(
        email: String,
        password: String
    ) {
        if (email.isBlank()) {
            throw FieldNotValidException("Email is blank")
        }
        if (password.length < 8) {
            throw FieldNotValidException("Password length is too short, pick at least 8 character password")
        }
    }
}

class FieldNotValidException(e: String) : RuntimeException(e)