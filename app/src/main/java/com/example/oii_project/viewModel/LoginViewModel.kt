package com.example.oii_project.viewModel

import androidx.lifecycle.ViewModel
import com.example.oii_project.App
import com.example.oii_project.data.dto.JwtTokenResponse
import com.example.oii_project.data.dto.LoginUser
import com.example.oii_project.repo.LoginUserRepo
import com.example.oii_project.utils.Converter
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginUserRepo
): ViewModel() {

    fun doAuthentication(loginUser: LoginUser,
                         observer: DisposableSingleObserver<JwtTokenResponse>
    ) {
        val loginUserRemote = Converter.fromLoginUserToLoginUserRemote(loginUser)
        repository.remoteCall { App.instance.apiService.postAuth(loginUserRemote)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }
}