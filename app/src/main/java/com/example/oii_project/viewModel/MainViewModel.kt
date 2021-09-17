package com.example.oii_project.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.oii_project.data.dto.AppDto
import com.example.oii_project.data.dto.CommentDto
import com.example.oii_project.data.features.apps.AppsDataSourceImpl
import com.example.oii_project.data.features.comments.CommentDataSourceImpl
import com.example.oii_project.data.presentation.AppsModel
import com.example.oii_project.data.presentation.CommentModel

class MainViewModel () : ViewModel(){
    //temp data models
    private var appsModel = AppsModel(AppsDataSourceImpl())
    val commentsModel = CommentModel(CommentDataSourceImpl())


    //apps_list
    val appsList: LiveData<List<AppDto>> get() = _appsList
    private val _appsList = MutableLiveData<List<AppDto>>()

    //comments list
    val commentsList: LiveData<List<CommentDto>> get() = _commentsList
    private val _commentsList = MutableLiveData<List<CommentDto>>()

    fun getApps(){
        //Я не совсем знаю, как правильно реализовывать апросы к серверу через RX, поэтому пока так оставлю
        _appsList.value = appsModel.getApps()
    }

    fun getComments(){
        //Я не совсем знаю, как правильно реализовывать апросы к серверу через RX, поэтому пока так оставлю
        _commentsList.value = commentsModel.getComments()
    }

}