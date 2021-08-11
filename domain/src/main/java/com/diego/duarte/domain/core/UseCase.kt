package com.diego.duarte.domain

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import kotlinx.coroutines.flow.collect


abstract class UseCase<T, in Params>(private val scope: CoroutineScope): KoinComponent {


    abstract fun run(params: Params? = null): Flow<T>

    operator fun invoke(
        params: Params? = null,
        onError: ((Throwable) -> Unit) = {},
        onSuccess: (T) -> Unit = {}
    ) {
        scope.launch(Dispatchers.IO) {
            try {
                run(params).collect{
                    withContext(Dispatchers.Main) {
                        onSuccess(it)
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onError(e)
                }
            }
        }

    }

    fun cancel() = scope.coroutineContext.cancelChildren()
}
