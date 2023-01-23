package com.nipunapps.moviedb.core

sealed class Resource<T>(val data: T? = null, val error: String? = null) {
    class Loading<T>(data: T? = null) : Resource<T>(data = data)
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(error: String) : Resource<T>(error = error)
}
