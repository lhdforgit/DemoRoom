package com.example.demoroomapp.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.demoroomapp.data.entity.PostRoomEntity

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(post: PostRoomEntity)

    @Query("SELECT * from posts")
    fun getAllPost(): LiveData<List<PostRoomEntity>>
}