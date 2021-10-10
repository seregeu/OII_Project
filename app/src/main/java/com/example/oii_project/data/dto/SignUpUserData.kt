package com.example.oii_project.data.dto

data class SignUpUserData (
    val username: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val gender: String = "",
    val secondMail: String = "",
    val cards: String = "",
    val imageUrl: String= "",
    val bot: Boolean,
    )