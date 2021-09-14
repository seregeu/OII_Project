package com.example.oii_project.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.oii_project.R
import com.example.oii_project.adapters.AppAdapter
import com.example.oii_project.adapters.CommentRecyclerAdapter
import com.example.oii_project.data.presentation.CommentModel
import com.example.summer_school_hw.model.data.features.movies.CommentDataSourceImpl

class ApplicationDetailsFragment : Fragment() {

    lateinit var recyclerViewComments: RecyclerView
    private lateinit var commentsRecyclerAdapter: CommentRecyclerAdapter
    val commentsModel = CommentModel(CommentDataSourceImpl())

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
        recyclerViewComments = view.findViewById(R.id.rv_comments)
        commentsRecyclerAdapter = CommentRecyclerAdapter()
        commentsRecyclerAdapter.submitList(commentsModel.getComments())
        recyclerViewComments.adapter = commentsRecyclerAdapter
    }
}