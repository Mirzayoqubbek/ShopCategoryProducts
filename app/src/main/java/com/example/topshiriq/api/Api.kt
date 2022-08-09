package com.example.topshiriq.api

import com.example.topshiriq.model.CategoryModel
import com.example.topshiriq.model.PostModel
import com.example.topshiriq.model.BaseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("get_categories")
    fun getCategories(): Call<BaseModel<List<CategoryModel>>>

    @GET("get_top_products")
    fun getPost(): Call<BaseModel<List<PostModel>>>

    @GET("get_products/{category_id}")
    fun getCategoryPost(@Path("category_id") categoryId: Int): Call<BaseModel<List<PostModel>>>
}
