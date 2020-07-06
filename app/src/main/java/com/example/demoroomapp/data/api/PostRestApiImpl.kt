package com.example.demoroomapp.data.api

import androidx.lifecycle.LiveData
import com.example.demoroomapp.data.entity.PostEntity
import com.example.demoroomapp.data.util.ApiResponse
import com.example.demoroomapp.data.util.ServiceGenerator

class PostRestApiImpl : PostRestApi {
    fun getInstance(): PostRestApi {
        return PostRestApiImpl()
    }

    private val service = ServiceGenerator.createService(ApiService::class.java)

    override fun getFirstPost(): LiveData<ApiResponse<PostEntity>> {
        return service.getFirstPost()
    }

    override fun getAllPost(): LiveData<ApiResponse<List<PostEntity>>> {
        return service.getAllPost()
    }
}