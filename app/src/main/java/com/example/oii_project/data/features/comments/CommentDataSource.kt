package com.example.oii_project.data.features.comments

import com.example.oii_project.data.dto.CommentDto


interface CommentDataSource {
    fun getComments(): List<CommentDto>
}