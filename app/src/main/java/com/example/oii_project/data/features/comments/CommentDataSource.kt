package com.example.oii_project.data.features.comments

import com.example.summer_school_hw.model.data.dto.CommentDto

interface CommentDataSource {
    fun getComments(): List<CommentDto>
}