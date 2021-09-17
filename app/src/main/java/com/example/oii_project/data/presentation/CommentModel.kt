package com.example.oii_project.data.presentation

import com.example.oii_project.data.features.comments.CommentDataSourceImpl

class CommentModel(
private val commentDataSource: CommentDataSourceImpl
) {

    fun getComments() = commentDataSource.getComments()
}