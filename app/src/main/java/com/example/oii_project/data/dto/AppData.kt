package com.example.oii_project.data.dto

import kotlinx.serialization.SerialName

data class AppData (
    val apps: List<App>
)

data class App (
    val title: String,
    val rating: Long,

    @SerialName("image_url")
    val imageURL: String,

    @SerialName("downloads_amount")
    val downloadsAmount: Long,

    @SerialName("app_id")
    val appID: Long
)
