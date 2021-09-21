package com.example.oii_project.network

import android.content.Context
import android.provider.Settings.Global.getString
import android.util.Log
import com.example.oii_project.App
import com.example.oii_project.R
import com.example.oii_project.data.dto.*
import com.example.oii_project.utils.NetworkConstants.BASE_URL
import com.example.oii_project.utils.addJsonConverter
import com.example.oii_project.utils.setClient
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.http.*

interface ApiService {
    /**
     * Authorization
     */
    @POST("/api/token/auth/")
    fun postAuth(
        @Body loginUserRemote: LoginUserRemote
    ): Single<JwtTokenResponse>
    /**
     * Registration
     */
    @POST("/api/account/register/")
    fun postSignUpUser(@Body signUpUserDataRemote: SignUpUserDataRemote)
    : Single<SignUpResponse>
    /**
     * Get apps list
     */
    @GET("/api/app/list/")
    fun getAppsList(@Header("Authorization") jwtToken: String)
            : Single<AppData>
    /**
     * Get app comments by id
     */
    @GET("/api/action/comment/{app_id}")
    fun getAppCommentsById(@Path("app_id") appId: Long, @Header("Authorization") jwtToken: String)
            : Single<CommentsData>

    companion object {
        fun create(): ApiService {
            val sharedPref =  App.appContext.getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE);
            var baseUrl = ""
            with (sharedPref) {
                baseUrl = getString("BASE_URL","")?:""
            }
            Log.i("ip sevice","created "+baseUrl)
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .setClient()
                .addJsonConverter()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}