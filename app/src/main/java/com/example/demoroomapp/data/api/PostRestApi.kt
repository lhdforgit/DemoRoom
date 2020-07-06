package com.example.demoroomapp.data.api

import androidx.lifecycle.LiveData
import com.example.demoroomapp.data.entity.PostEntity
import com.example.demoroomapp.data.util.ApiResponse

interface PostRestApi {
    fun getFirstPost() : LiveData<ApiResponse<PostEntity>>
    fun getAllPost() : LiveData<ApiResponse<List<PostEntity>>>
}