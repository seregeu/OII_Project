package com.example.oii_project.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import coil.load
import com.example.oii_project.R
import com.example.oii_project.callbacks.CommentRecyclerCallback
import com.example.oii_project.data.dto.CommentDto

class CommentRecyclerAdapter: ListAdapter<CommentDto, RecyclerView.ViewHolder>(CommentRecyclerCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.comment_lits_item, parent, false)
        return CommentViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CommentViewHolder)
            holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var commentAvatar: ImageView? = itemView.findViewById(R.id.comment_author_avatar)
        fun bind(commentDto: CommentDto){
            commentAvatar?.load(commentDto.avatarUrl)
        }
    }
}
