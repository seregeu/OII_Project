package com.example.oii_project.data.features.apps

import com.example.oii_project.data.dto.AppDto


interface AppsDataSource {
    fun getApps():List<AppDto>
}