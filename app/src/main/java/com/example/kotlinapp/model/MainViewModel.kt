package com.example.kotlinapp.model

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinapp.activities.MainActivity
import com.example.kotlinapp.internet.networkCheck
import com.example.kotlinapp.repository.MainRepository
import kotlinx.coroutines.*

class MainViewModel constructor(private val mainRepository: MainRepository,private val mainActivity:MainActivity) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val quoteList = MutableLiveData<List<Post>>()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    fun getAllQuotes() {
        if (networkCheck.isInternetAvailable(mainActivity)){
            job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
                val response = mainRepository.getAllQuotes()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        quoteList.postValue(response.body())
                        loading.value = false
                    } else {
                        onError("Error : ${response.message()} ")
                    }
                }
            }
        }else{
            Toast.makeText(mainActivity, "Internet not Available..", Toast.LENGTH_SHORT).show()
        }

    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}