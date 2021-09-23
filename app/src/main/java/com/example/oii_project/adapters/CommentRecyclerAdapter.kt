package com.example.oii_project.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import coil.load
import com.example.oii_project.R
import com.example.oii_project.callbacks.CommentRecyclerCallback
import com.example.oii_project.data.dto.Comment

class CommentRecyclerAdapter: ListAdapter<Comment, RecyclerView.ViewHolder>(CommentRecyclerCallback()) {


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
        private var commentAuthorName: TextView? = itemView.findViewById(R.id.comment_author_name)
        private var commentText: TextView? = itemView.findViewById(R.id.comment_text)
        fun bind(comment: Comment){
            if (comment.user.imageUrl!=""){
                commentAvatar?.load(comment.user.imageUrl)
            }else{
                commentAvatar?.load("https://clck.ru/XjukU") //заглушка
            }
            commentAuthorName?.text = comment.username // тоже временно, т.к. у юзера нет логина
            commentText?.text = comment.content
        }
    }
}
