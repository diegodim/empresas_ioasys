package com.diego.duarte.presentation_main

import androidx.lifecycle.ViewModel
import com.diego.duarte.base_presentation.mapper.EnterpriseBindingMapper
import com.diego.duarte.base_presentation.model.EnterpriseBinding
import com.diego.duarte.base_presentation.utils.extensions.*
import com.diego.duarte.domain.usecase.Search
import org.koin.core.component.KoinComponent

class MainViewModel: ViewModel(), KoinComponent {

    private val search: Search by useCase()

    private val _searchEnterpriseState by viewState<List<EnterpriseBinding>>()

    val searchEnterpriseViewState = _searchEnterpriseState.asLiveData()


    private var currentQuery: String? = null


    fun search(query: String) {
        currentQuery = query
        if (query.isNotEmpty()) {
            search(
                params = Search.Params(
                    query
                ),
                onSuccess = {
                    _searchEnterpriseState.postSuccess(EnterpriseBindingMapper().fromDomain(it))
                },
                onError = {
                    _searchEnterpriseState.postError(it)
                }
            )
        }
        else _searchEnterpriseState.postSuccess(listOf<EnterpriseBinding>())
    }
    fun clearState() {
        _searchEnterpriseState.postNeutral()
    }

    fun getCurrentQuery() = currentQuery
}