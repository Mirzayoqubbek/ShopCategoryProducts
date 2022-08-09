package com.example.topshiriq.api

import androidx.lifecycle.MutableLiveData
import com.example.topshiriq.model.BaseModel
import com.example.topshiriq.model.CategoryModel
import com.example.topshiriq.model.PostModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repasitory() {
    fun getCategoriy(
        error: MutableLiveData<String>,
        success: MutableLiveData<List<CategoryModel>>
    ) {
        NetworkManager.getApiService().getCategories().enqueue(object :
            Callback<BaseModel<List<CategoryModel>>> {
            override fun onResponse(
                call: Call<BaseModel<List<CategoryModel>>>,
                response: Response<BaseModel<List<CategoryModel>>>
            ) {
                if (response.isSuccessful && response.body()!!.success) {
                    success.value = response.body()!!.data
                } else {
                    error.value = response.body()?.message ?: response.message()
                }
            }

            override fun onFailure(call: Call<BaseModel<List<CategoryModel>>>, t: Throwable) {
                error.value = t.localizedMessage
            }

        })
    }

    fun getPost(error: MutableLiveData<String>, success: MutableLiveData<List<PostModel>>) {
        NetworkManager.getApiService().getPost().enqueue(object :
            Callback<BaseModel<List<PostModel>>> {
            override fun onResponse(
                call: Call<BaseModel<List<PostModel>>>,
                response: Response<BaseModel<List<PostModel>>>
            ) {
                if (response.isSuccessful) {
                    success.value = response.body()!!.data
                } else {
                    error.value = response.body()?.message ?: response.message()
                }
            }

            override fun onFailure(call: Call<BaseModel<List<PostModel>>>, t: Throwable) {
                error.value = t.localizedMessage
            }

        })
    }

    fun getPostById(
        id: Int,
        error: MutableLiveData<String>,
        success: MutableLiveData<List<PostModel>>
    ) {
        NetworkManager.getApiService().getCategoryPost(id)
            .enqueue(object :
                Callback<BaseModel<List<PostModel>>> {
                override fun onResponse(
                    call: Call<BaseModel<List<PostModel>>>,
                    response: Response<BaseModel<List<PostModel>>>
                ) {
                    if (response.isSuccessful) {
                        success.value = response.body()!!.data
                    } else {
                        error.value = response.body()?.message ?: response.message()
                    }
                }

                override fun onFailure(call: Call<BaseModel<List<PostModel>>>, t: Throwable) {
                    error.value = t.localizedMessage
                }

            })
    }
}