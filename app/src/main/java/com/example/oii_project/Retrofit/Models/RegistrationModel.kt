package com.example.oii_project.Retrofit.Models
import com.google.gson.annotations.SerializedName

data class RegistrationModel (
    val username: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val email: String,
    val password: String,
    val phone: String,
    val gender: String,
    @SerializedName("second_mail")
    val secondMail: String,
    val cards: String
)
