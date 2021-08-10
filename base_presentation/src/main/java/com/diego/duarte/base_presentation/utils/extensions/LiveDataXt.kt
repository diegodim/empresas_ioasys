package com.diego.duarte.base_presentation.utils.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.diego.duarte.base_presentation.core.ViewState
import com.diego.duarte.base_presentation.utils.EventLiveData
import com.diego.duarte.base_presentation.core.ViewState.Status.NEUTRAL
import com.diego.duarte.base_presentation.core.ViewState.Status.SUCCESS
import com.diego.duarte.base_presentation.core.ViewState.Status.ERROR
import com.diego.duarte.base_presentation.core.ViewState.Status.LOADING

fun <T> EventLiveData<ViewState<T>>.postNeutral() {
    postValue(ViewState(NEUTRAL, null, null))
}

fun <T> EventLiveData<ViewState<T>>.postSuccess(data: T) {
    postValue(ViewState(SUCCESS, data, null))
}

fun <T> EventLiveData<ViewState<T>>.postError(error: Throwable?) {
    postValue(ViewState(ERROR, null, error))
}

fun <T> EventLiveData<ViewState<T>>.postError(message: String) {
    postValue(ViewState(ERROR, null, RuntimeException(message)))
}

fun <T> EventLiveData<ViewState<T>>.postLoading() {
    postValue(ViewState(LOADING, null, null))
}

fun <T> EventLiveData<T>.asLiveData(): LiveData<T> = this

fun <T> LiveData<ViewState<T>>.observeLiveData(
    lifecycleOwner: LifecycleOwner,
    isSingleEvent: Boolean = false,
    event: (ViewState<T>) -> Unit
) {
    observe(lifecycleOwner, Observer {
        (this as? EventLiveData)?.apply {
            getContent(isSingleEvent)?.let { event(it) }
            return@Observer
        }

        value?.let { event(it) }
    })
}
