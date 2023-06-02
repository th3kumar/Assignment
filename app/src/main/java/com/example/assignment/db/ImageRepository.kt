package com.example.assignment.db

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ImageRepository {

    private val api: ApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(ApiService::class.java)
    }

    suspend fun getImages(): List<Image> {
        return api.getImages()
    }
}