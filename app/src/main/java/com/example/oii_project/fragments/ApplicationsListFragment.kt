package com.example.oii_project.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oii_project.App
import com.example.oii_project.R
import com.example.oii_project.adapters.AppAdapter
import com.example.oii_project.data.dto.*
import com.example.oii_project.interfaces.AppItemCallback
import com.example.oii_project.utils.Utility
import com.example.oii_project.viewModel.AppsViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.observers.DisposableSingleObserver

@AndroidEntryPoint
class ApplicationsListFragment : Fragment(), AppItemCallback {
   // private val mainViewModel: MainViewModel by viewModels()
    private val viewModel: AppsViewModel by viewModels()

    private lateinit var appRecycler: RecyclerView
    private lateinit var  appAdapter: AppAdapter
    private lateinit var navController: NavController

    private lateinit var searchView: androidx.appcompat.widget.SearchView
    var recyleAppsData = emptyList<AppItem>()


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
        searchView = view.findViewById(R.id.search_view)
        getAppsList()
        performSearch()
    }

    private fun performSearch() {
        searchView.setOnQueryTextListener(object :androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                search(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                search(newText)
                return true
            }
        })
    }

    private fun search(text: String?) {
        var matchedApps = mutableListOf<AppItem>()
        text?.let {
            recyleAppsData.forEach { movie ->
                if (movie.title.startsWith(text, true)) {
                    matchedApps.add(movie)
                    appAdapter.submitList(matchedApps)

                }
                if(text.length==0){
                    appAdapter.submitList(recyleAppsData)
                }
            }
            appAdapter.submitList(matchedApps)
        }
    }

    private fun getAppsList(){
        val sharedPref =  App.appContext.getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE);
        var jwtToken = ""
        with (sharedPref) {
            jwtToken = "JWT "+getString("TOKEN","")?:""
        }
        viewModel.getAppsList(jwtToken,
            object : DisposableSingleObserver<AppData>() {
                override fun onError(e: Throwable) {
                    Utility.showToast("Error", App.appContext)
                }
                override fun onSuccess(appData: AppData) {
                    Log.i("appData",appData.apps.toString())
                    recyleAppsData = appData.apps
                    updateAppsList(appData.apps)
                }
            }
        )
    }

    private fun updateAppsList(appsList: List<AppItem>){
        appAdapter.submitList(appsList)
    }

    private fun initRecyclerMovies(view: View) {
        appRecycler = view.findViewById(R.id.rv_apps)
        appAdapter = AppAdapter()
        appAdapter.initListener(this)
        appRecycler.adapter = appAdapter
        GridLayoutManager(
            context, // context
            2, // span count
            RecyclerView.VERTICAL, // orientation
            false // reverse layout
        ).apply {
            appRecycler.layoutManager = this
        }
    }

    //Пиши тут Сергей, что надо делать при нажатии
    override fun onAppClick(appItem: AppItem) {
        val bundle = bundleOf("appId" to appItem.appID,
        "appName" to appItem.title,"imageUrl" to appItem.imageURL)
        Log.d("Item Pressed", appItem.toString())
        navController.navigate(R.id.action_applicationsListFragment_to_applicationDetailsFragment,bundle)
    }
}