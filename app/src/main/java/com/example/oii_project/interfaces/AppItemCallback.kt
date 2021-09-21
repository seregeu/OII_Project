package com.example.oii_project.interfaces

import com.example.oii_project.data.dto.AppItem

interface AppItemCallback {
    fun onAppClick(appItem: AppItem)
}