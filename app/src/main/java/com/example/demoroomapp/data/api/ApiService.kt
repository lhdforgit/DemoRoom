package com.example.demoroomapp.data.api

import androidx.lifecycle.LiveData
import com.example.demoroomapp.data.entity.PostEntity
import com.example.demoroomapp.data.util.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("/posts/1")
    fun getFirstPost(): LiveData<ApiResponse<PostEntity>>

    @GET("/posts/")
    fun getAllPost(): LiveData<ApiResponse<List<PostEntity>>>
}