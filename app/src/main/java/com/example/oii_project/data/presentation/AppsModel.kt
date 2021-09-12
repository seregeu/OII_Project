package com.example.summer_school_hw.model.data.presentation

import com.example.summer_school_hw.model.data.features.movies.AppsDataSourceImpl

class AppsModel(
    private val appsDataSource: AppsDataSourceImpl
) {

    fun getApps() = appsDataSource.getApps()
}