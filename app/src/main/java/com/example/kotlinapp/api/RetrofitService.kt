package com.example.kotlinapp.api

import com.example.kotlinapp.model.Post
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//Before changing//
//interface RetrofitService {
//    @GET("/posts")
//    suspend fun getPosts(): Response<List<Post>>
//}

//After converting to mvvm//
interface RetrofitService {

    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>

    companion object {
        var retrofitService: RetrofitService? = null
        fun makeRetrofitService(): RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }

    }
}

