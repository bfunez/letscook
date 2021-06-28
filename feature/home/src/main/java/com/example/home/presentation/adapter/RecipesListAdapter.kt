package com.example.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.home.domain.model.Recipe
import com.example.home.presentation.HomeViewModel
import com.example.home.presentation.viewHolder.ItemViewHolder
import com.sample.core.presentation.base.BaseListAdapter

class RecipesListAdapter(val viewModel: HomeViewModel) : BaseListAdapter<Recipe>(
    itemsSame = { old, new -> old.id == new.id },
    contentsSame = { old, new -> old == new }) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder = ItemViewHolder( inflater, parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ItemViewHolder -> holder.bind(viewModel, getItem(position))
        }
    }
}