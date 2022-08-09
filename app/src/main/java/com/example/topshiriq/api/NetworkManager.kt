package com.example.topshiriq.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object NetworkManager {

    var retrofit: Retrofit? = null

    var api: Api? = null

    fun getApiService(): Api {
        if (api == null) {
            retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
            api = retrofit!!.create(Api::class.java)
        }

        return api!!
    }

}