package com.sample.core.domain.model

sealed class Resource<out T> {
    data class Success<out T>(val data: T): Resource<T>()
    data class Failure(var errorCode: String? = "", val httpError: HttpError? = null): Resource<Nothing>()
    data class Loading(val loadingData: Any? = null, val showLoading: Boolean): Resource<Nothing>()
}