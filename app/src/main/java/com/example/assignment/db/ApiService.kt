package com.example.assignment.db

import retrofit2.http.GET

interface ApiService {

    @GET("photos")
    suspend fun getImages(): List<Image>
}
