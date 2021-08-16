package com.diego.duarte.presentation_main

import androidx.lifecycle.ViewModel
import com.diego.duarte.base_presentation.utils.extensions.*
import com.diego.duarte.domain.model.Enterprise
import com.diego.duarte.domain.usecase.Search
import org.koin.core.component.KoinComponent

class MainViewModel: ViewModel(), KoinComponent {

    private val search: Search by useCase()

    private val _searchState by viewState<List<Enterprise>>()

    val searchViewState = _searchState.asLiveData()

    fun search(key: String){
        search(
            params = Search.Params(
                key
            ),
            onSuccess = {
                _searchState.postSuccess(it)
            },
            onError = {
                _searchState.postError(it)
            }
        )
    }
    fun clearState() {
        _searchState.postNeutral()
    }
}