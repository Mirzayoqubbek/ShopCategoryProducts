package com.example.topshiriq.model

data class BaseModel<T>(
    val success: Boolean,
    val data: T,
    val message: String,
    val error_code: Int
)