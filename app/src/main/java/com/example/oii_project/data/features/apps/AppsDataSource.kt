package com.example.oii_project.data.features.apps

import com.example.summer_school_hw.model.data.dto.AppDto

interface AppsDataSource {
    fun getApps():List<AppDto>
}