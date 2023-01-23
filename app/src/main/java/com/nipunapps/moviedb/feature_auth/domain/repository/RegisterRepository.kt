package com.nipunapps.moviedb.feature_auth.domain.repository

import com.nipunapps.moviedb.core.Resource
import com.nipunapps.moviedb.feature_auth.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface RegisterRepository {


    fun createUserWithEmailAndPassword(
        email: String,
        password: String
    ) : Flow<Resource<String>>

    fun loginWithEmailAndPassword(
        email: String,
        password: String
    ): Flow<Resource<UserModel?>>

}