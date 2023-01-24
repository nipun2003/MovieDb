package com.nipunapps.moviedb.feature_auth.data.repository

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.nipunapps.moviedb.core.Resource
import com.nipunapps.moviedb.feature_auth.data.remote.FirestoreManager
import com.nipunapps.moviedb.feature_auth.domain.model.UserModel
import com.nipunapps.moviedb.feature_auth.domain.repository.RegisterRepository
import com.nipunapps.moviedb.feature_auth.util.FieldNotValidException
import com.nipunapps.moviedb.feature_auth.util.FieldValidator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class RegisterRepositoryImpl(
    private val firestoreManager: FirestoreManager
) : RegisterRepository {

    private val auth = Firebase.auth

    override fun createUserWithEmailAndPassword(
        email: String,
        password: String
    ): Flow<Resource<String>> = flow {
        emit(Resource.Loading<String>())
        try {
            FieldValidator.validateEmailAndPassword(email, password)
            val res = auth.createUserWithEmailAndPassword(email, password).await()
            res.user?.let {
                emit(Resource.Success<String>(it.providerId))
            } ?: emit(
                Resource.Error<String>(
                    error = "Something went wrong"
                )
            )
            auth.signOut()
        } catch (e: FieldNotValidException) {
            emit(
                Resource.Error<String>(
                    error = e.message.toString()
                )
            )
        }
    }

    override fun loginWithEmailAndPassword(
        email: String,
        password: String
    ): Flow<Resource<UserModel?>> = flow {
        emit(Resource.Loading<UserModel?>())
        try {
            val res = auth.signInWithEmailAndPassword(email, password).await()
            res.user?.let { user ->
                val userId = user.providerId
                emit(Resource.Success<UserModel?>(data = firestoreManager.getUserWithUserId(userId)))
            } ?: emit(Resource.Error<UserModel?>("Something went wrong"))
        } catch (e: Exception) {
            emit(Resource.Error<UserModel?>(e.message.toString()))
        }
    }
}