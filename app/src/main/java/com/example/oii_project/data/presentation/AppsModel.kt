package com.example.summer_school_hw.model.data.presentation

import com.example.oii_project.model.data.features.movies.AppsDataSourceImpl

class AppsModel(
    private val appsDataSource: AppsDataSourceImpl
) {

    fun getApps() = appsDataSource.getApps()
}