package com.example.oii_project.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import coil.load
import com.example.oii_project.R
import com.example.oii_project.callbacks.CommentRecyclerCallback
import com.example.oii_project.data.dto.CommentDto
import com.example.oii_project.interfaces.AppItemCallback
import com.google.android.material.imageview.ShapeableImageView

class CommentRecyclerAdapter: ListAdapter<CommentDto, RecyclerView.ViewHolder>(CommentRecyclerCallback()) {

    private lateinit var listener: AppItemCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.application_list_item, parent, false)
        return AppViewHolder(view)
    }

    fun initListener(listener: AppItemCallback){
        this.listener = listener
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AppViewHolder)
            holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    class AppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var appCover: ShapeableImageView? = itemView.findViewById(R.id.list_app_cover)
        fun bind(commentDto: CommentDto){
            appCover?.load(commentDto.avatarUrl)
        }
    }
}
