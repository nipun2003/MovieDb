package com.nipunapps.moviedb.feature_auth.data.remote

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.nipunapps.moviedb.feature_auth.domain.model.UserModel
import kotlinx.coroutines.tasks.await

class FirestoreManager {

    private val storage = Firebase.firestore
    private val userRef = storage.collection("users")

    suspend fun getUserWithUserId(userId: String): UserModel? {
        return try {
            userRef.document(userId).get().await().toObject(UserModel::class.java)
        } catch (e: Exception) {
            Log.e("Firestore", e.message.toString())
            null
        }
    }
}