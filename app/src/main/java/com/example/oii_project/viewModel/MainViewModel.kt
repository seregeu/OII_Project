package com.example.oii_project.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.oii_project.data.dto.CommentDto
import com.example.oii_project.data.features.comments.CommentDataSourceImpl
import com.example.oii_project.data.presentation.CommentModel

class MainViewModel () : ViewModel(){
    //temp data models
    val commentsModel = CommentModel(CommentDataSourceImpl())



    //comments list
    val commentsList: LiveData<List<CommentDto>> get() = _commentsList
    private val _commentsList = MutableLiveData<List<CommentDto>>()

    fun getComments(){
        //Я не совсем знаю, как правильно реализовывать апросы к серверу через RX, поэтому пока так оставлю
        _commentsList.value = commentsModel.getComments()
    }

}