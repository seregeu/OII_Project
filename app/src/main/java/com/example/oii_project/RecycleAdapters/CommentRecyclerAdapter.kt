package com.example.summer_school_hw.model.data.RecycleAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.oii_project.R
import com.example.summer_school_hw.model.data.dto.CommentDto
import kotlin.properties.Delegates

class CommentRecyclerAdapter() :
    RecyclerView.Adapter<CommentRecyclerAdapter.MyViewHolder>() {

    var comments: List<CommentDto> by Delegates.observable(emptyList()) { _, oldList, newList ->
        autoNotifyComments(oldList, newList) { o, n -> o.username == n.username }
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var _ImageView: ImageView? = null
        var _TextViewUsername: TextView? = null
        var _TextViewComment: TextView? = null
        init {
            _ImageView = itemView.findViewById(R.id.comment_author_avatar)
            _TextViewUsername = itemView.findViewById(R.id.comment_author_name)
            _TextViewComment = itemView.findViewById(R.id.comment_text)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.comment_lits_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val comment = comments[position]
        holder._ImageView?.load(comment.avatarUrl)
        holder._TextViewComment?.text = comment.commentText
        holder._TextViewUsername?.text = comment.username
    }

    override fun getItemCount() = comments.size
    fun <T> RecyclerView.Adapter<*>.autoNotifyComments(oldList: List<CommentDto>, newList: List<T>, compare: (T, T) -> Boolean) {

        val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition] == newList[newItemPosition]
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldList[oldItemPosition] == newList[newItemPosition]
            }

            override fun getOldListSize() = oldList.size
            override fun getNewListSize() = newList.size
        })
        diff.dispatchUpdatesTo(this)
    }
}