package com.diego.duarte.base_presentation.utils.extensions


import androidx.lifecycle.ViewModel
import com.diego.duarte.base_presentation.core.ViewState
import com.diego.duarte.base_presentation.utils.EventLiveData
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

fun <T> viewState() = lazy {
    EventLiveData<ViewState<T>>()
}

inline fun <V, reified U> V.useCase() where U : UseCase<*, *>, V : ViewModel, V : KoinComponent
        = inject<U> {
    parametersOf(viewModelScope)
}


