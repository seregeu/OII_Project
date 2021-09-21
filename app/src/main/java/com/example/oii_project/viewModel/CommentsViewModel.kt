package com.example.oii_project.viewModel

import androidx.lifecycle.ViewModel
import com.example.oii_project.App
import com.example.oii_project.data.dto.CommentsData
import com.example.oii_project.repo.CommentsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel @Inject constructor(
    private val repository: CommentsRepo
): ViewModel() {

    fun getAppCommentsById(appId:Long, jwtToken:String, observer: DisposableSingleObserver<CommentsData>) {
        repository.remoteCall { App.instance.apiService.getAppCommentsById(appId,jwtToken)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }
}