package com.example.oii_project.callbacks

import androidx.recyclerview.widget.DiffUtil
import com.example.oii_project.data.dto.AppDto

class GridAppRecyclerCallback : DiffUtil.ItemCallback<AppDto>() {

    override fun areItemsTheSame(oldItem: AppDto, newItem: AppDto): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: AppDto, newItem: AppDto): Boolean {
        return oldItem == newItem
    }
}