package com.example.oii_project.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isGone
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.oii_project.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class LoginFragment : Fragment() {
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
            navController.navigate(R.id.action_loginFragment_to_applicationsListFragment)
        }
        val registerLabel:TextView = view.findViewById(R.id.label_register)
        registerLabel.setOnClickListener{
            navController.navigate(R.id.action_loginFragment_to_registrationFragment)
        }
    }
}