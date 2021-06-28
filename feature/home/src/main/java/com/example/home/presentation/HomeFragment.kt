package com.example.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import com.example.home.R
import com.example.home.databinding.FragmentHomeBinding
import com.example.home.di.component.DaggerHomeComponent
import com.sample.core.presentation.base.BaseFragment
import com.example.home.di.module.HomeModule
import com.example.home.presentation.adapter.RecipesListAdapter
import com.sample.core.presentation.extension.observe
import com.sample.letscook.LetsCookApp
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    private val stateObserver = Observer<HomeViewModel.ViewState> {
        viewAdapter.submitList(it.recipesList)
    }

    @Inject
    lateinit var viewAdapter: RecipesListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentHomeBinding.inflate( inflater, container, false)
        viewBinding.lifecycleOwner = viewLifecycleOwner
        return viewBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireCompatActivity().setSupportActionBar(viewBinding.toolbar)
        observe(viewModel.stateLiveData, stateObserver)
        viewModel.loadData()
    }


    /**
     * Initialize dagger injection dependency graph.
     */
    override fun onInitDependencyInjection() {
        DaggerHomeComponent
            .builder()
            .coreComponent(LetsCookApp.coreComponent(requireContext()))
            .homeModule(HomeModule(this))
            .build()
            .inject(this)
    }

    override fun onInitDataBinding() {
        list.adapter = viewAdapter
        search.isIconified = true
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                search(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                search(newText)
                return true
            }
        })
    }

    private fun search(query : String){
        viewModel.searchItems(query)
    }
}