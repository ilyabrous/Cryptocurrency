package com.example.courseaplc.common

sealed class Resourсe<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resourсe<T>(data)
    class Error<T>(message: String, data: T? = null) : Resourсe<T>(data, message)
    class Loading<T>(data: T? = null) : Resourсe<T>(data)
}