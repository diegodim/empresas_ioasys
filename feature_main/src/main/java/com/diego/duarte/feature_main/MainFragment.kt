package com.diego.duarte.feature_main

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.diego.duarte.base_feature.core.BaseFragment
import com.diego.duarte.base_feature.utils.delegateproperties.viewInflateBinding
import com.diego.duarte.feature_main.databinding.FragmentMainBinding
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getColor
import com.diego.duarte.presentation_main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : BaseFragment() {

    private val viewModel: MainViewModel by viewModel()

    private val binding by viewInflateBinding(FragmentMainBinding::inflate)

    private lateinit var searchView: SearchView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun setupView() {
        super.setupView()
        binding.toolbar.also {
            (requireActivity() as? AppCompatActivity)?.apply {
                setSupportActionBar(it)
            }
            setHasOptionsMenu(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {

        val searchViewMenuItem: MenuItem = menu.findItem(R.id.action_search)
        searchView = searchViewMenuItem.actionView as SearchView
        // Logic for search view states
        searchViewMenuItem.apply {
            setOnActionExpandListener(object : MenuItem.OnActionExpandListener {

                override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                    searchView.queryHint = getString(R.string.content_search_view)
                    val searchEditText =
                        searchView.findViewById(androidx.appcompat.R.id.search_src_text) as EditText
                    searchEditText.setTextColor(getColor(requireContext(), R.color.white))

                    return true
                }

                override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {

                    return true
                }
            })
        }
        setupSearchView()
    }

    fun setupSearchView(){

        searchView.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(s: String?): Boolean {
                    searchView.clearFocus() //if you want to close keyboard
                    return false
                }

                override fun onQueryTextChange(text: String): Boolean {

                    return false
                }
            })
        }

    }


}