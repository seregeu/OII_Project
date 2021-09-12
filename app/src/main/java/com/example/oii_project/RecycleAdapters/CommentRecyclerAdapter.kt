package com.example.summer_school_hw.model.data.RecycleAdapters

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import coil.load
import com.example.oii_project.R
import com.example.summer_school_hw.model.data.dto.CommentDto
import kotlin.properties.Delegates

class CommentRecyclerAdapter(): RecyclerView.Adapter<CommentRecyclerAdapter.CommentViewHolder>()  {

    var commentList: List<CommentDto> by Delegates.observable(emptyList()) { _, oldList, newList ->
        autoNotify(oldList, newList) { o, n -> o.commentText == n.commentText }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.comment_lits_item, parent, false)
        return CommentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var authorName: TextView? = null

        init {
            authorName = itemView.findViewById(R.id.comment_author_name)
        }

    }
    interface OnAppListener{
        fun onAppClick(position: Int)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun <T> RecyclerView.Adapter<*>.autoNotify(oldList: List<CommentDto>, newList: List<T>, compare: (T, T) -> Boolean) {

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

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val app = commentList[position]
        holder.authorName?.text = app.commentText
        Log.i("Bind: ", "bind, position = " + position);
    }
}
