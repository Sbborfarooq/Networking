package com.example.networking

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("posts") // Replace with your endpoint
    fun getYourData(): Call<List<Post>>
}