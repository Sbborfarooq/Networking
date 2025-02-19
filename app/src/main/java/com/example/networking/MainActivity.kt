package com.example.networking

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create an instance of the API service
        val apiService = RetrofitClient.getInstance().create(ApiService::class.java)

        // Make a network call to fetch posts
        apiService.getYourData().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    // Handle the successful response
                    val posts = response.body()
                    posts?.forEach {
                        Log.d("MainActivity", "Post ID: ${it.id}, Title: ${it.title}")
                    }
                } else {
                    // Handle the error response
                    Log.e("MainActivity", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                // Handle the failure
                Log.e("MainActivity", "Failure: ${t.message}")
            }
        })
    }
}