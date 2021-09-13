package com.example.oii_project.data.features.apps

import com.example.oii_project.model.data.dto.AppDto


interface AppsDataSource {
    fun getApps():List<AppDto>
}