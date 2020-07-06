package com.example.demoroomapp.data.repository

import androidx.lifecycle.LiveData
import com.example.demoroomapp.data.entity.PostEntity
import com.example.demoroomapp.data.entity.PostRoomEntity
import com.example.demoroomapp.data.util.Resource

interface PostRepository {
    fun getFirstPost() : LiveData<Resource<PostEntity>>
    fun getAllPostByRoom(): LiveData<Resource<List<PostRoomEntity>>>
}