package com.diego.duarte.base_presentation.utils.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.diego.duarte.base_presentation.core.ViewState
import com.diego.duarte.base_presentation.utils.EventLiveData
import com.diego.duarte.base_presentation.core.ViewState.Status.NEUTRAL
import com.diego.duarte.base_presentation.core.ViewState.Status.SUCCESS
import com.diego.duarte.base_presentation.core.ViewState.Status.ERROR
import com.diego.duarte.base_presentation.core.ViewState.Status.LOADING

fun <T> MutableLiveData<ViewState<T>>.postNeutral() {
    value = ViewState(NEUTRAL, null, null)
}

fun <T> MutableLiveData<ViewState<T>>.setSuccess(data: T) {
    value = ViewState(SUCCESS, data, null)
}

fun <T> MutableLiveData<ViewState<T>>.setError(error: Throwable?) {
    value = ViewState(ERROR, null, error)
}

fun <T> MutableLiveData<ViewState<T>>.setError(message: String?) {
    value = ViewState(ERROR, null, RuntimeException(message))
}

fun <T> MutableLiveData<ViewState<T>>.postSuccess(data: T) {
    postValue(ViewState(SUCCESS, data, null))
}

fun <T> MutableLiveData<ViewState<T>>.postError(error: Throwable?) {
    postValue(ViewState(ERROR, null, error))
}

fun <T> MutableLiveData<ViewState<T>>.postError(message: String?) {
    postValue(ViewState(ERROR, null, RuntimeException(message)))
}

fun <T> MutableLiveData<ViewState<T>>.postLoading() {
    postValue(ViewState(LOADING, null, null))
}

fun <T> MutableLiveData<ViewState<T>>.setLoading(){
    value = ViewState(LOADING, null, null)
}

fun <T> MutableLiveData<T>.asLiveData(): LiveData<T> = this

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
