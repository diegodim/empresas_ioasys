package com.diego.duarte.base_feature

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView


class RestorableSearchView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : SearchView(context, attrs) {


    private var mOnQueryTextListener: OnQueryTextListener? = null

    /**
     * Search hint icon removed by editing default search view style
     */

    init {
        maxWidth = Integer.MAX_VALUE
    }

    override fun setQuery(query: CharSequence?, submit: Boolean) {
        if (!submit) {
            holdQueryTextListener()
            super.setQuery(query, submit)
            resumeQueryTextListener()
        } else {
            super.setQuery(query, submit)
        }
    }

    override fun setOnQueryTextListener(listener: OnQueryTextListener?) {
        mOnQueryTextListener = listener
        super.setOnQueryTextListener(listener)
    }

    private fun holdQueryTextListener() {
        super.setOnQueryTextListener(null)
    }

    private fun resumeQueryTextListener() {
        super.setOnQueryTextListener(mOnQueryTextListener)
    }

    override fun setLayoutParams(params: ViewGroup.LayoutParams?) {
        params?.width = LayoutParams.MATCH_PARENT
        super.setLayoutParams(params)
    }

    override fun onActionViewCollapsed() {
        holdQueryTextListener()
        super.onActionViewCollapsed()
        resumeQueryTextListener()
    }

    override fun onActionViewExpanded() {
        holdQueryTextListener()
        super.onActionViewExpanded()
        resumeQueryTextListener()
    }
}