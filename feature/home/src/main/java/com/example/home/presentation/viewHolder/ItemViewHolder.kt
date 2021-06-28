package com.example.home.presentation.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.home.databinding.ListItemLayoutBinding
import com.example.home.domain.model.Recipe
import com.example.home.presentation.HomeViewModel
import com.sample.core.presentation.base.BaseViewHolder

class ItemViewHolder (
    inflater: LayoutInflater, parent: ViewGroup
) : BaseViewHolder<ListItemLayoutBinding>(
binding = ListItemLayoutBinding.inflate(inflater, parent, false)
) {
    fun bind(viewModel:HomeViewModel, recipe : Recipe) {
        binding.recipe = recipe
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }
}