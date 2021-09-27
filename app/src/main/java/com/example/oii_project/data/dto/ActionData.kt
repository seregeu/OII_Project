package com.example.oii_project.data.dto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ActionData (
    @SerialName("app_id")
    val appID: Long,
    val data: String,
    @SerialName("action_type")
    val actionType: Long
)

@Serializable
data class ActionAnswer (
    val details: String,
)

