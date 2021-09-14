package com.example.oii_project.callbacks

import androidx.recyclerview.widget.DiffUtil
import com.example.oii_project.data.dto.CommentDto

class CommentRecyclerCallback: DiffUtil.ItemCallback<CommentDto>() {

    override fun areItemsTheSame(oldItem: CommentDto, newItem: CommentDto): Boolean {
        return oldItem.commentText == newItem.commentText
    }

    override fun areContentsTheSame(oldItem: CommentDto, newItem: CommentDto): Boolean {
        return oldItem == newItem
    }
}