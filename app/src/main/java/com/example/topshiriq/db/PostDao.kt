package com.example.topshiriq.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.topshiriq.model.CategoryModel
import com.example.topshiriq.model.PostModel

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items: List<PostModel>)

    @Query("select * from post")
    fun getAllPost(): List<PostModel>
}