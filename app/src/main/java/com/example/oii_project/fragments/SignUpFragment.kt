package com.example.oii_project.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.oii_project.App
import com.example.oii_project.R
import com.example.oii_project.data.dto.SignUpUserData
import com.example.oii_project.utils.Utility
import com.example.oii_project.viewModel.SignUpViewModel
import io.reactivex.observers.DisposableSingleObserver
import com.example.oii_project.data.dto.SignUpResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment() {
    private val viewModel: SignUpViewModel by viewModels()

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners(view)
    }

    private fun setListeners(view: View) {
        navController = view.findNavController()

        val loginButton: Button = view.findViewById(R.id.registration_button)
        loginButton.setOnClickListener {
            doSignUp()
        }
    }

    private fun doSignUp() {
        var gender = ""
        val selectedId: Int = view?.findViewById<RadioGroup>(R.id.registration_gender_radiogroup)
            ?.checkedRadioButtonId ?: -1
        if (selectedId == R.id.radio_men){
            gender = "m"
        }
        else if (selectedId == R.id.radio_women) {
            gender = "w"
        }
        viewModel.doSignUp(
            SignUpUserData(
                username = view?.findViewById<EditText>(R.id.register_username)?.text.toString(),
                password = view?.findViewById<EditText>(R.id.register_password)?.text.toString(),
                email = view?.findViewById<EditText>(R.id.register_email)?.text.toString(),
                phone = view?.findViewById<EditText>(R.id.register_phone)?.text.toString(),
                secondMail = view?.findViewById<EditText>(R.id.register_second_mail)?.text.toString(),
                gender = gender,
                cards = view?.findViewById<EditText>(R.id.register_card_number)?.text.toString(),
                firstName = view?.findViewById<EditText>(R.id.register_name)?.text.toString(),
                lastName = view?.findViewById<EditText>(R.id.register_second_name)?.text.toString()
                ),
            object : DisposableSingleObserver<SignUpResponse>() {
                override fun onError(e: Throwable) {
                    Utility.showToast(e.message, App.appContext)
                }
                override fun onSuccess(signUptestResponse: SignUpResponse) {
                    navController.navigate(R.id.action_registrationFragment_to_loginFragment)
                }
            }
        )
    }
}