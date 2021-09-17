package com.example.oii_project.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oii_project.R
import com.example.oii_project.adapters.AppAdapter
import com.example.oii_project.adapters.CommentRecyclerAdapter
import com.example.oii_project.data.dto.CommentDto
import com.example.oii_project.data.presentation.CommentModel
import com.example.oii_project.interface_items.CustomImageButton
import com.example.oii_project.model.data.dto.AppDto
import com.example.oii_project.viewModel.MainViewModel
import com.example.summer_school_hw.model.data.features.movies.CommentDataSourceImpl
import kotlinx.coroutines.supervisorScope

class ApplicationDetailsFragment : Fragment() {
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var navController: NavController

    lateinit var recyclerViewComments: RecyclerView
    private lateinit var commentsRecyclerAdapter: CommentRecyclerAdapter
    val commentsModel = CommentModel(CommentDataSourceImpl())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    private fun initObservers(){
        mainViewModel.commentsList.observe(viewLifecycleOwner, Observer(::updateCommentsList))
        mainViewModel.getComments()
    }
    private fun updateCommentsList(commentsList: List<CommentDto>){
        commentsRecyclerAdapter.submitList(commentsList)
    }

    private fun setListeners(view:View){
        navController = view.findNavController()

        val labelAddReview: TextView = view.findViewById(R.id.label_add_review)
        labelAddReview.setOnClickListener{
            navController.navigate(R.id.action_applicationDetailsFragment_to_addCommentFragment)
        }
        val customImageButton = CustomImageButton(getActivity(), view)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_application_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        commentsRecyclerAdapter = CommentRecyclerAdapter()
        recyclerViewComments = view.findViewById(R.id.rv_comments)
        recyclerViewComments.adapter = commentsRecyclerAdapter
        LinearLayoutManager(
            context, // context
            RecyclerView.VERTICAL, // orientation
            false // reverse layout
        ).apply {
            recyclerViewComments.layoutManager = this
        }
        initObservers()
        mainViewModel.getComments()
        setListeners(view)
    }
}