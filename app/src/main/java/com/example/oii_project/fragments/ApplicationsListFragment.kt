package com.example.oii_project.fragments

import android.R.attr
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oii_project.R
import com.example.oii_project.model.data.dto.AppDto
import com.example.oii_project.model.data.features.movies.AppsDataSourceImpl
import com.example.summer_school_hw.model.data.RecycleAdapters.GridAppsResyclerAdapter
import com.example.summer_school_hw.model.data.presentation.AppsModel


class ApplicationsListFragment : Fragment(),GridAppsResyclerAdapter.OnAppListener {

    lateinit var recyclerViewApps: RecyclerView
    private val appRecyclerAdapter: GridAppsResyclerAdapter = GridAppsResyclerAdapter(this)
    private lateinit var navController: NavController
    //temp
    private var appsModel = AppsModel(AppsDataSourceImpl())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_applications_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        initRecyclerMovies(view)
        updateResyclerMovies(appsModel.getApps())

    }

    override fun onAppClick(position: Int) {
        navController.navigate(R.id.action_applicationsListFragment_to_applicationDetailsFragment)
    }

    private fun initRecyclerMovies(view: View) {
        recyclerViewApps = view.findViewById(R.id.rv_apps)
// initialize grid layout manager
        GridLayoutManager(
            context, // context
            2, // span count
            RecyclerView.VERTICAL, // orientation
            false // reverse layout
        ).apply {
            recyclerViewApps.layoutManager = this
        }
        recyclerViewApps.adapter = appRecyclerAdapter
    }


    fun updateResyclerMovies(list: List<AppDto>){
        appRecyclerAdapter.appsList = list
        recyclerViewApps.scrollToPosition(0)
    }

}