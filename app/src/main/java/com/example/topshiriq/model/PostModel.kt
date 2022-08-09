package com.example.topshiriq.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "post")
data class PostModel(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    val name: String,
    val price: String,
    val image: String
) : Serializable