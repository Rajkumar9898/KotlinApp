package com.example.kotlinapp.repository


import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinapp.api.RetrofitService
import com.example.kotlinapp.api.RetrofitService.Companion.retrofitService
import com.example.kotlinapp.internet.networkCheck
import com.example.kotlinapp.model.Post

//class MainRepository constructor(private val retrofitService: RetrofitService, private val applicationContext: Context) {
//    private val quotesLiveData = MutableLiveData<Post>()
//    val quotes: LiveData<Post>
//        get() = quotes
//
//}
//
//suspend fun getAllQuotes() {
//    if (networkCheck.isInternetAvailable()) {
//        try {
//            val result = retrofitService?.getPosts()
//            if (result?.body() != null) {
//
//
//            } else {
//                //newsLiveData.postValue("Apk Error");
//            }
//
//        } catch (e: Exception) {
//
//        }
//    } else {
//        Toast.makeText(this, "Internet not Available..", Toast.LENGTH_SHORT)
//            .show()
//        retrofitService?.getPosts()
//    }
//}


class MainRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllQuotes() = retrofitService.getPosts()

}
