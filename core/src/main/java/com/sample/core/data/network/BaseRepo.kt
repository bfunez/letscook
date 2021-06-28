package com.sample.core.data.network

import com.sample.core.data.CoroutineContextProvider
import com.sample.core.domain.model.HttpError
import com.sample.core.domain.model.Resource
import kotlinx.coroutines.withContext
import java.lang.Exception

abstract class BaseRepo constructor(
    private val coroutineContext: CoroutineContextProvider
) {

    protected suspend fun <T : Any> fetchData(dataProvider: suspend () -> Resource<T>): Resource<T> =
        try {
            withContext(coroutineContext.io) {
                dataProvider()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(httpError = HttpError(Throwable(ErrorCodes.GENERAL_NETWORK_ERROR)))
        }
}