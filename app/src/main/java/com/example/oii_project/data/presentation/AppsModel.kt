package com.example.oii_project.data.presentation

import com.example.oii_project.data.features.apps.AppsDataSourceImpl

class AppsModel(
    private val appsDataSource: AppsDataSourceImpl
) {

    fun getApps() = appsDataSource.getApps()
}