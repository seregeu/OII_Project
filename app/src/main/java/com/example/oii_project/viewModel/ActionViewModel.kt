package com.example.oii_project.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.oii_project.App
import com.example.oii_project.data.dto.ActionAnswer
import com.example.oii_project.data.dto.ActionData
import com.example.oii_project.data.dto.AppData
import com.example.oii_project.repo.ActionRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.Response
import okhttp3.ResponseBody
import javax.inject.Inject

@HiltViewModel
class ActionViewModel @Inject constructor(
    private val repository: ActionRepo
): ViewModel() {

    fun makeAction(actionData: ActionData, observer: DisposableSingleObserver<ResponseBody>) {
        val sharedPref =  App.appContext.getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE);
        var jwtToken = ""
        with (sharedPref) {
            jwtToken = "JWT "+getString("TOKEN","")?:""
        }
        repository.remoteCall { App.instance.apiService.makeAction(jwtToken, actionData)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }
}