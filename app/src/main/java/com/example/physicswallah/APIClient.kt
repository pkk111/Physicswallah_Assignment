package com.example.physicswallah

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {

    private var apiClient :APIService? = null
    private const val BASE_URL = " https://my-json-server.typicode.com/"

    fun getInstance() : APIService {
        if (apiClient == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            apiClient = retrofit.create(APIService::class.java)
        }
        return apiClient!!
    }
}