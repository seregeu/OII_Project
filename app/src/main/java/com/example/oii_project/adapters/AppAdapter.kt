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
import com.example.oii_project.callbacks.GridAppRecyclerCallback
import com.example.oii_project.interfaces.AppItemCallback
import com.example.oii_project.data.dto.AppDto
import com.google.android.material.imageview.ShapeableImageView

class AppAdapter: ListAdapter<AppDto, RecyclerView.ViewHolder>(GridAppRecyclerCallback()) {

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
        holder.itemView.setOnClickListener{
            listener.onAppClick(getItem(position).title)
        }
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    class AppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var appCover: ShapeableImageView? = itemView.findViewById(R.id.list_app_cover)
        private var appName: TextView? = itemView.findViewById(R.id.list_app_name)
        private var appRating: RatingBar?= itemView.findViewById(R.id.list_ratingBar_indicator)
        fun bind(appDto: AppDto){
            appName?.text = appDto.title
            appCover?.load(appDto.imageUrl)
            appRating?.rating = appDto.rateScore
            val animation = AnimationUtils.loadAnimation(itemView.context, android.R.anim.slide_in_left)
            itemView.startAnimation(animation)
        }
    }
}
