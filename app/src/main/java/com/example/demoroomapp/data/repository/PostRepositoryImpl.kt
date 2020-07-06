package com.example.demoroomapp.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.demoroomapp.data.api.PostRestApi
import com.example.demoroomapp.data.entity.PostEntity
import com.example.demoroomapp.data.entity.PostRoomEntity
import com.example.demoroomapp.data.util.StatusNetwork
import com.example.demoroomapp.data.room.PostDao
import com.example.demoroomapp.data.util.Resource

class PostRepositoryImpl(private val restApi: PostRestApi, private val postDao: PostDao) :
    PostRepository {

    fun getInstance(): PostRepository {
        return PostRepositoryImpl(restApi, postDao)
    }

    override fun getFirstPost(): LiveData<Resource<PostEntity>> {
        val result = MediatorLiveData<Resource<PostEntity>>()
        result.value = Resource.loading(null)
        val api = restApi.getFirstPost()
        result.addSource(api) { response ->
            when {
                response == null -> result.setValue(
                    Resource.error(
                        StatusNetwork.ERROR,
                        "Error response null",
                        null
                    )
                )
                response.body != null -> {
                    result.value = Resource.success(response.body, "Load data Server")
                    result.value?.data?.let {
                        val post = PostRoomEntity().transformToRoomData(it)
                        insert(post)
                    }
                }
                else -> result.setValue(
                    Resource.error(
                        response.code, response.errorMessage
                            ?: "", null
                    )
                )
            }
        }
        return result
    }

    override fun getAllPostByRoom(): LiveData<Resource<List<PostRoomEntity>>> {
        val result = MediatorLiveData<Resource<List<PostRoomEntity>>>()
        result.value = Resource.loading(null)
        val local = postDao.getAllPost()
        result.addSource(local) { response ->
            if (response != null && response.isNotEmpty()) {
                result.value = Resource.success(response, "Load data Room")
            }
        }
        val api = restApi.getAllPost()
        result.addSource(api) { response ->
            when {
                response == null -> result.setValue(
                    Resource.error(
                        StatusNetwork.ERROR,
                        "Error response null",
                        null
                    )
                )
                response.body != null -> {
                    Log.i("===============","SERVER BE CALL")
                    response.body.run {
                        forEach {
                            val post = PostRoomEntity().transformToRoomData(it)
                            insert(post)
                        }
                    }
                }
                else -> result.setValue(
                    Resource.error(
                        response.code, response.errorMessage
                            ?: "", null
                    )
                )
            }
        }
        return result
    }

    private fun insert(post: PostRoomEntity) {
        postDao.insert(post)
    }
}