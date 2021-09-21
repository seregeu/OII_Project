package com.example.oii_project.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oii_project.App
import com.example.oii_project.R
import com.example.oii_project.adapters.CommentRecyclerAdapter
import com.example.oii_project.data.dto.*
import com.example.oii_project.data.features.comments.CommentDataSourceImpl
import com.example.oii_project.data.presentation.CommentModel
import com.example.oii_project.interface_items.CustomImageButton
import com.example.oii_project.utils.Utility
import com.example.oii_project.viewModel.AppsViewModel
import com.example.oii_project.viewModel.CommentsViewModel
import com.example.oii_project.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.observers.DisposableSingleObserver

@AndroidEntryPoint
class ApplicationDetailsFragment : Fragment() {
    private lateinit var navController: NavController

    lateinit var recyclerViewComments: RecyclerView
    private lateinit var commentsRecyclerAdapter: CommentRecyclerAdapter

    private val viewModel: CommentsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    private fun initObservers(){
        /*mainViewModel.commentsList.observe(viewLifecycleOwner, Observer(::updateCommentsList))
        mainViewModel.getComments()*/
    }
    private fun updateCommentsList(commentsList: List<Comment>){
        commentsRecyclerAdapter.submitList(commentsList)
    }

    private fun getAppCommentsById(appId: Long){
        val sharedPref =  App.appContext.getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE);
        var jwtToken = ""
        with (sharedPref) {
            jwtToken = "JWT "+getString("TOKEN","")?:""
        }
        viewModel.getAppCommentsById(appId,jwtToken,
            object : DisposableSingleObserver<CommentsData>() {
                override fun onError(e: Throwable) {
                    Utility.showToast("Error", App.appContext)
                }
                override fun onSuccess(commentsData: CommentsData) {
                    Log.i("appData",commentsData.comments.toString())
                    updateCommentsList(commentsData.comments)
                }
            }
        )
    }

    private fun setListeners(view:View){
        navController = view.findNavController()

        val labelAddReview: TextView = view.findViewById(R.id.label_add_review)
        labelAddReview.setOnClickListener{
            navController.navigate(R.id.action_applicationDetailsFragment_to_addCommentFragment)
        }
        val customImageBustton = CustomImageButton(activity,view)
        

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
        /*initObservers()
        mainViewModel.getComments()*/
        getAppCommentsById(0)
        setListeners(view)
    }
}