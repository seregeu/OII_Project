package com.example.oii_project.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.oii_project.App
import com.example.oii_project.R
import com.example.oii_project.data.dto.JwtTokenResponse
import com.example.oii_project.data.dto.LoginUser
import com.example.oii_project.utils.Utility
import com.example.oii_project.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.observers.DisposableSingleObserver


@AndroidEntryPoint
class LoginFragment : Fragment() {
    private val viewModel: LoginViewModel  by viewModels()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners(view)
    }

    private fun setListeners(view:View){
        navController = view.findNavController()

        val loginButton: Button = view.findViewById(R.id.login_button)
        loginButton.setOnClickListener{
            doAuthentication()
        }
        val registerLabel:TextView = view.findViewById(R.id.label_register)
        registerLabel.setOnClickListener{

            navController.navigate(R.id.action_loginFragment_to_registrationFragment)
        }
        val setProxyButton:Button = view.findViewById(R.id.login_set_proxy)
        setProxyButton.setOnClickListener{
            setSharedpreferences(view)
        }
    }

    private fun setSharedpreferences(view:View){
        val login_proxy = view?.findViewById<EditText>(R.id.login_proxy_addr)
        val baseUrl = login_proxy?.text.toString()
        if (baseUrl == ""){
            login_proxy.requestFocus()
        }else{
            val sharedPref = activity?.getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE);
            with (sharedPref!!.edit()) {
                putString("BASE_URL","http://"+baseUrl+":8000/")
                apply()
            }
        }
    }

    private fun doAuthentication(){
        viewModel.doAuthentication(
            LoginUser(
                username = view?.findViewById<EditText>(R.id.login_username)?.text.toString(),
                password = view?.findViewById<EditText>(R.id.login_password)?.text.toString()
            ),
            object : DisposableSingleObserver<JwtTokenResponse>() {
                override fun onError(e: Throwable) {
                    Utility.showToast("Error", App.appContext)
                }
                override fun onSuccess(token: JwtTokenResponse) {
                    val sharedPref = activity?.getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE);
                    with (sharedPref!!.edit()) {
                        putString("TOKEN",token.token)
                        apply()
                    }
                    navController.navigate(R.id.action_loginFragment_to_applicationsListFragment)
                }
            }
        )
    }
}