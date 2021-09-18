package com.example.oii_project.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppData (
    val apps: List<AppItem>
)
@Serializable
@SerialName("image_url")
data class AppItem (
    val title: String,
    val rating: Long,

    @SerialName("image_url")
    val imageURL: String,

    @SerialName("downloads_amount")
    val downloadsAmount: Long,

    @SerialName("app_id")
    val appID: Long
)
