package com.example.oii_project.callbacks

import androidx.recyclerview.widget.DiffUtil
import com.example.oii_project.data.dto.AppItem

class GridAppRecyclerCallback : DiffUtil.ItemCallback<AppItem>() {

    override fun areItemsTheSame(oldItem: AppItem, newItem: AppItem): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: AppItem, newItem: AppItem): Boolean {
        return oldItem == newItem
    }
}