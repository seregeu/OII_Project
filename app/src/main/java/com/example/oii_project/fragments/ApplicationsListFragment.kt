package com.example.oii_project.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oii_project.App
import com.example.oii_project.R
import com.example.oii_project.data.features.apps.AppsDataSourceImpl
import com.example.oii_project.adapters.AppAdapter
import com.example.oii_project.data.dto.*
import com.example.oii_project.interfaces.AppItemCallback
import com.example.oii_project.viewModel.MainViewModel
import com.example.oii_project.data.presentation.AppsModel
import com.example.oii_project.utils.Utility
import com.example.oii_project.viewModel.AppsViewModel
import com.example.oii_project.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.observers.DisposableSingleObserver

@AndroidEntryPoint
class ApplicationsListFragment : Fragment(), AppItemCallback {
   // private val mainViewModel: MainViewModel by viewModels()
    private val viewModel: AppsViewModel by viewModels()

    private lateinit var appRecycler: RecyclerView
    private lateinit var  appAdapter: AppAdapter
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
       // initObservers()
        //Тута получаю приложения
      //  mainViewModel.getApps()
        getAppsList()
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
                    updateAppsList(appData.apps)
                }
            }
        )
    }

  /*  private fun initObservers(){
        mainViewModel.appsList.observe(viewLifecycleOwner, Observer(::updateAppsList))
    }*/

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
    override fun onAppClick(title: String) {
        Log.d("Item Pressed", title)
        navController.navigate(R.id.action_applicationsListFragment_to_applicationDetailsFragment)
    }
}