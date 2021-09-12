package com.example.oii_project.data.presentation

import com.example.summer_school_hw.model.data.features.movies.CommentDataSourceImpl

class CommentModel(
private val commentDataSource: CommentDataSourceImpl
) {

    fun getComments() = commentDataSource.getComments()
}