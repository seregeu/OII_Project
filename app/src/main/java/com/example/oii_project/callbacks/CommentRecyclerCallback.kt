package com.example.oii_project.callbacks

import androidx.recyclerview.widget.DiffUtil
import com.example.oii_project.data.dto.Comment

class CommentRecyclerCallback: DiffUtil.ItemCallback<Comment>() {

    override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem.content == newItem.content
    }

    override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem == newItem
    }
}