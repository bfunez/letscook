package com.sample.core.domain.model


inline fun <T> Resource<T>.onSuccess(action: (T) -> Unit): Resource<T> {
    if (this is Resource.Success) action(data)
    return this
}

inline fun <T> Resource<T>.onFailure(action: (HttpError) -> Unit) {
    if (this is Resource.Failure) httpError?.let { action(it) }
}
