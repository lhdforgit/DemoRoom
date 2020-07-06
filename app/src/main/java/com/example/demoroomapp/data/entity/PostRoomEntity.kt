package com.example.demoroomapp.data.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
class PostRoomEntity {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "userId")
    var userId: Int? = null

    @ColumnInfo(name = "id")
    var id: Int? = null

    @ColumnInfo(name = "title")
    var title: String? = null

    @ColumnInfo(name = "body")
    var body: String? = null

    @Ignore
    fun transformToRoomData(entity: PostEntity?): PostRoomEntity {
        val data = PostRoomEntity()
        entity?.run {
            data.userId = userId
            data.id = id
            data.title = title
            data.body = body
        }
        return data
    }

    @Ignore
    override fun toString(): String {
        return "PostRoomEntity(userId=$userId, id=$id, title=$title, body=$body)"
    }


}