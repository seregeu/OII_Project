package com.example.oii_project.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CommentsData (
    val comments: List<Comment>
)

@Serializable
data class Comment (
    val content: String,
    val username: String,
    val user: User
)

@Serializable
data class User (
    val phone: String,
    val gender: String,
    @SerialName("second_mail")
    val secondMail: String,
    @SerialName("img_url")
    val imageUrl: String,
    val cards: String,
)