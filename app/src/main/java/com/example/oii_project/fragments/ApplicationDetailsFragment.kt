package com.example.oii_project.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.oii_project.R
import com.example.oii_project.data.presentation.CommentModel
import com.example.summer_school_hw.model.data.RecycleAdapters.CommentRecyclerAdapter
import com.example.summer_school_hw.model.data.features.movies.CommentDataSourceImpl

class ApplicationDetailsFragment : Fragment() {

    lateinit var recyclerViewComments: RecyclerView
    private val commentsAdapter: CommentRecyclerAdapter = CommentRecyclerAdapter()
    private var commentsModel = CommentModel(CommentDataSourceImpl())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_application_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerComments(view)
        commentsAdapter.comments = commentsModel.getComments()
    }

    private fun initRecyclerComments(view: View) {
        recyclerViewComments = view.findViewById(R.id.rv_comments)
        recyclerViewComments.adapter = commentsAdapter
    }
}