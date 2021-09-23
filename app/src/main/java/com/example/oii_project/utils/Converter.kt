package com.example.oii_project.utils

import com.example.oii_project.data.dto.LoginUser
import com.example.oii_project.data.dto.LoginUserRemote
import com.example.oii_project.data.dto.SignUpUserData
import com.example.oii_project.data.dto.SignUpUserDataRemote

object Converter {

    fun fromLoginUserToLoginUserRemote(loginUser: LoginUser): LoginUserRemote =
        LoginUserRemote(
            username  = loginUser.username,
            password = loginUser.password
        )

    fun fromSignUpUserDataToSignUpUserDataRemote(signUpUserData: SignUpUserData)
    : SignUpUserDataRemote = SignUpUserDataRemote(
        username = signUpUserData.username,
        password = signUpUserData.password,
        email = signUpUserData.email,
        phone = signUpUserData.phone,
        gender = signUpUserData.gender,
        secondMail = signUpUserData.secondMail,
        cards = signUpUserData.cards,
        firstName = signUpUserData.firstName,
        lastName = signUpUserData.lastName,
        imageUrl = signUpUserData.imageUrl
    )
}