package com.example.oii_project.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignUpUserDataRemote(
    val username: String,
    val password: String,
    val email: String,
    val phone: String,
    val gender: String,
    @SerialName("second_mail")
    val secondMail: String,
    val cards: String,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val lastName: String
)

@Serializable
data class LoginUserRemote(
    val username: String,
    val password: String
)

@Serializable
data class JwtTokenResponse(
    val token: String
)

@Serializable
data class SignUpResponse(
    val username: String,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val lastName: String
)