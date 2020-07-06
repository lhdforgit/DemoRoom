package com.example.demoroomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.demoroomapp.data.api.PostRestApiImpl
import com.example.demoroomapp.data.repository.PostRepositoryImpl
import com.example.demoroomapp.data.room.PostRoomDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postDao = PostRoomDatabase.getDatabase(application).postDao()

        val repository = PostRepositoryImpl(PostRestApiImpl().getInstance(), postDao).getInstance()
//        repository.getFirstPost().observe(this@MainActivity, Observer {
//            it?.apply {
//                Log.i("=========","RESOURCE:  ${it.toString()}")
//                data?.let { post ->
//                    Log.i("=========","DATA:  ${post.toString()}")
//                }
//            }
//        })

        repository.getAllPostByRoom().observe(this@MainActivity, Observer {
            it?.run {
                Log.i("=============", "Resource: ${it.toString()}")
                data?.run {
                    forEach {
                        //Log.i("=========", "DATA ROOM:  ${it.toString()}")
                    }

                }
            }
        })
    }
}