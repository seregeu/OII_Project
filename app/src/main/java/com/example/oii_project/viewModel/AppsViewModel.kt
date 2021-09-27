package com.example.oii_project.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.oii_project.App
import com.example.oii_project.data.dto.AppData
import com.example.oii_project.data.dto.JwtTokenResponse
import com.example.oii_project.data.dto.LoginUser
import com.example.oii_project.repo.AppsRepo
import com.example.oii_project.repo.LoginUserRepo
import com.example.oii_project.utils.Converter
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class AppsViewModel @Inject constructor(
    private val repository: AppsRepo
): ViewModel() {
    fun getAppsList(jwtToken:String, observer: DisposableSingleObserver<AppData>) {
        repository.remoteCall { App.instance.apiService.getAppsList(jwtToken)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }
}