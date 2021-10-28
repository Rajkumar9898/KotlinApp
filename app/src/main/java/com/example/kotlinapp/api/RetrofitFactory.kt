//package com.example.kotlinapp
//
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//object RetrofitFactory {
//    const val BASE_URL = "https://jsonplaceholder.typicode.com"
//
//    fun makeRetrofitService(): RetrofitService {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build().create(RetrofitService::class.java)
//    }
//}