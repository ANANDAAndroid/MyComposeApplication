package com.demo.mycomposeapplication.api

sealed class Status<out T> {

    data class Success<out T>(val data: T) : Status<T>()
    data object Loading : Status<Nothing>()
    data class Failure(val isNetworkError: Boolean, val code: Int?) : Status<Nothing>()
}