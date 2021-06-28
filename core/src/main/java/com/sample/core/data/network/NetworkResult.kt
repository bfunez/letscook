package com.sample.core.data.network

import android.util.Log
import com.sample.core.data.network.ErrorCodes.GENERAL_NETWORK_ERROR
import com.sample.core.domain.model.HttpError
import com.sample.core.domain.model.Resource
import retrofit2.Response

object ErrorCodes{
    const val GENERAL_NETWORK_ERROR = "Something went wrong, please try again."
}

interface DomainMapper<T : Any> {
    fun mapToDomainModel(): T
}

inline fun <T : Any> Response<T>.onSuccess(action: (T) -> Unit): Response<T> {
    if (isSuccessful) body()?.run(action)
    return this
}

inline fun <T : Any> Response<T>.onFailure(action: (HttpError) -> Unit) {
    if (!isSuccessful) errorBody()?.run { action(HttpError(Throwable(message()), code())) }
}

fun <T : Any> Response<T>.getData(): Resource<T> {
    try {
        onSuccess {
            println("going here $it")
            return Resource.Success(it)
        }
        onFailure {
            Log.d("Domain Mapper error", "Failed $it")
            return Resource.Failure(httpError = it)
        }
        return Resource.Failure(httpError = HttpError(Throwable(GENERAL_NETWORK_ERROR)))
    } catch (e: Exception) {
        return Resource.Failure(httpError = HttpError(Throwable(GENERAL_NETWORK_ERROR)))
    }
}
