package com.diego.duarte.feature_main.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.diego.duarte.base_feature.core.BaseFragment
import com.diego.duarte.base_feature.utils.delegateproperties.viewInflateBinding
import com.diego.duarte.feature_main.databinding.FragmentMainBinding
import android.widget.EditText
import androidx.core.content.ContextCompat.getColor
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.diego.duarte.base_feature.RestorableSearchView
import com.diego.duarte.base_feature.utils.delegateproperties.navDirections
import com.diego.duarte.base_feature.utils.extensions.setInvisible
import com.diego.duarte.base_feature.utils.extensions.setVisible
import com.diego.duarte.base_feature.utils.extensions.setupSearchView
import com.diego.duarte.feature_main.adapter.EnterprisesAdapter
import com.diego.duarte.feature_main.R
import com.diego.duarte.feature_main.navigation.MainNavigation
import com.diego.duarte.presentation_main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : BaseFragment() {

    private val viewModel: MainViewModel by viewModel()
    private val navigation: MainNavigation by navDirections()

    private val binding by viewInflateBinding(FragmentMainBinding::inflate)

    private lateinit var enterprisesAdapter: EnterprisesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun setupView() {
        super.setupView()
        enterprisesAdapter = EnterprisesAdapter {
            navigation.navigateToEnterprise(it)
        }

        binding.mainToolbar.also {
            (requireActivity() as? AppCompatActivity)?.apply {
                setSupportActionBar(it)
            }
            setHasOptionsMenu(true)

            binding.mainRecyclerViewEnterprises.apply {
                adapter = enterprisesAdapter
                layoutManager = LinearLayoutManager(requireContext(),
                    LinearLayoutManager.VERTICAL, false)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)

        val searchViewMenuItem: MenuItem = menu.findItem(R.id.action_search)

        searchViewMenuItem.setupSearchView(
            getString(R.string.content_search_view),
            viewModel.getCurrentQuery(),
            { viewModel.search(it) },
            {
                enterprisesAdapter.items.clear()
                binding.mainRecyclerViewEnterprises.setInvisible()
                binding.mainLayoutSearchEmpty.setInvisible()
                binding.mainLayoutWelcome.setVisible()
            },
            {
                binding.mainLayoutSearchEmpty.setInvisible()
                binding.mainLayoutWelcome.setInvisible()
                binding.mainRecyclerViewEnterprises.setVisible()
            }
        )
    }



    override fun observeEvents(owner: LifecycleOwner) {
        super.observeEvents(owner)

        viewModel.searchEnterpriseViewState.onPostValue(
            lifecycleOwner = owner,
            onSuccess = {
                if(it.isNotEmpty()){

                    binding.mainRecyclerViewEnterprises.setVisible()
                    binding.mainLayoutSearchEmpty.setInvisible()
                    binding.mainLayoutWelcome.setInvisible()
                }else if (viewModel.getCurrentQuery().isNotEmpty()){
                    binding.mainRecyclerViewEnterprises.setInvisible()
                    binding.mainLayoutWelcome.setInvisible()
                    binding.mainLayoutSearchEmpty.setVisible()
                }
                else{
                    binding.mainRecyclerViewEnterprises.setInvisible()
                    binding.mainLayoutWelcome.setInvisible()
                    binding.mainLayoutSearchEmpty.setInvisible()
                }
                enterprisesAdapter.items = it.toMutableList()
            }
        )
    }


}