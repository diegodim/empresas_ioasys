package com.diego.duarte.base_feature.utils.extensions

import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat.getColor
import com.diego.duarte.base_feature.R
import com.diego.duarte.base_presentation.utils.extensions.isNull
import kotlinx.coroutines.*


fun MenuItem.setupSearchView(
    hint: String,
    query: String?,
    onQueryTextChange: (query: String) -> Unit,
    onMenuCollapsed: () -> Unit,
    onMenuExpanded: () -> Unit) {

    val menuSearchView = actionView as? SearchView

    val searchEditText =
        menuSearchView?.findViewById(androidx.appcompat.R.id.search_src_text) as EditText
    searchEditText.setTextColor(getColor(searchEditText.context, R.color.white))

    menuSearchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

        private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
        private var searchJob: Job? = null

        override fun onQueryTextSubmit(query: String): Boolean {
            menuSearchView?.clearFocus()
            return true
        }

        override fun onQueryTextChange(query: String): Boolean {
            searchJob?.cancel()
            searchJob = coroutineScope.launch {
                query?.let {
                    delay(500)
                    onQueryTextChange(it)
                }
            }

            return true
        }
    })

    menuSearchView?.queryHint = hint


    setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
        override fun onMenuItemActionExpand(p0: MenuItem?): Boolean {
            onMenuExpanded()
            return true
        }

        override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
            onMenuCollapsed()
            return true
        }
    })

    if (!query.isNull()) {
        expandActionView()
        menuSearchView?.setQuery(query, false)
    }



}

fun MenuItem.clearSearchView(){
    val menuSearchView = actionView as? SearchView
    menuSearchView?.setOnQueryTextListener(null)
}