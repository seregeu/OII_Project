package com.example.oii_project.viewModel

import androidx.lifecycle.ViewModel
import com.example.oii_project.App
import com.example.oii_project.data.dto.JwtTokenResponse
import com.example.oii_project.data.dto.SignUpResponse
import com.example.oii_project.data.dto.SignUpUserData
import com.example.oii_project.data.dto.SignUpUserDataRemote
import com.example.oii_project.repo.LoginUserRepo
import com.example.oii_project.utils.Converter
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: LoginUserRepo
): ViewModel() {

    fun doSignUp(signUpUserData: SignUpUserData,
                 observer: DisposableSingleObserver<SignUpResponse>
    ) {
        val signUpUserDataRemote = Converter
            .fromSignUpUserDataToSignUpUserDataRemote(signUpUserData)
        repository.remoteCall { App.instance.apiService.postSignUpUser(signUpUserDataRemote)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }
}