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
import com.example.summer_school_hw.model.data.dto.AppDto
import com.google.android.material.imageview.ShapeableImageView
import kotlin.properties.Delegates

class GridAppsResyclerAdapter(private val listener: OnAppListener): RecyclerView.Adapter<GridAppsResyclerAdapter.MyViewHolder>()  {

    var appsList: List<AppDto> by Delegates.observable(emptyList()) { _, oldList, newList ->
        autoNotify(oldList, newList) { o, n -> o.title == n.title }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.application_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)  {
        val app = appsList[position]
        holder.appName?.text = app.title
        holder.appCover?.load(app.imageUrl)
        holder.appRating?.rating  = app.rateScore
        Log.i("Bind: ", "bind, position = " + position);
        val animation = AnimationUtils.loadAnimation(holder.itemView.context,android.R.anim.slide_in_left)
        holder.itemView.startAnimation(animation)
    }

    override fun getItemCount(): Int {
        return appsList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener{
        var appCover: ShapeableImageView? = null
        var appName: TextView? = null
        var appRating: RatingBar?=null

        init {
            appCover = itemView.findViewById(R.id.list_app_cover)
            appName = itemView.findViewById(R.id.list_app_name)
            appRating = itemView.findViewById(R.id.list_ratingBar_indicator)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val posititon: Int = adapterPosition
            if (posititon!=RecyclerView.NO_POSITION) {
                listener.onAppClick(posititon)
            }
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

    fun <T> RecyclerView.Adapter<*>.autoNotify(oldList: List<AppDto>, newList: List<T>, compare: (T, T) -> Boolean) {

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
