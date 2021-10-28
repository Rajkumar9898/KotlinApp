package com.example.kotlinapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinapp.activities.MainActivity
import com.example.kotlinapp.repository.MainRepository

class MyViewModelFactory(private val repository: MainRepository,private val mainActivity: MainActivity) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(repository,mainActivity) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}