package com.example.oii_project.repo


import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginUserRepo @Inject constructor() {

    fun <T> remoteCall(remoteCall: ()-> Single<T>): Single<T> = remoteCall()
}