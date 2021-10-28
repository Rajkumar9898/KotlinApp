package com.example.kotlinapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinapp.repository.MainRepository
import com.example.kotlinapp.R
import com.example.kotlinapp.api.RetrofitService
import com.example.kotlinapp.adapter.NewsListAdapter
import com.example.kotlinapp.databinding.ActivityMainBinding
import com.example.kotlinapp.model.MainViewModel
import com.example.kotlinapp.model.MyViewModelFactory
import com.example.kotlinapp.preference.SharedPref

//Without MVVM//
//class MainActivity : AppCompatActivity() {
//    private lateinit var recyclerView: RecyclerView
//    private  val TAG = "MainActivity"
//    lateinit var postList:List<Post>
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        recyclerView=findViewById(R.id.recyclerView)
//        val toolbar: Toolbar = findViewById(R.id.toolbar_main);
//        setSupportActionBar(toolbar)
//
//        val service = RetrofitService.makeRetrofitService()
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = service.getPosts()
//            withContext(Dispatchers.Main) {
//                try {
//                    if (response.isSuccessful) {
//                        Log.d(TAG, "onCreate:Successful ")
//                        //Do something with response e.g show to the UI.
//                        postList= response.body()!!
//
//                        recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
//                        val items = fetchData()
//                        val adapter:NewsListAdapter= NewsListAdapter(postList)
//                        recyclerView.adapter = adapter
//                    } else {
//                        Toast.makeText(this@MainActivity, "Error: ${response.code()}", Toast.LENGTH_SHORT).show()
//                    }
//                } catch (e: HttpException) {
//                    Toast.makeText(this@MainActivity, "Exception ${e.message}", Toast.LENGTH_SHORT).show()
//                } catch (e: Throwable) {
//                    Toast.makeText(this@MainActivity, "Something went wrong", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }
//
//    private fun fetchData(): ArrayList<String> {
//        val list =ArrayList<String>()
//        for (i in 0 until 100){
//            list.add("Item $i")
//        }
//        return list
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.menu, menu)
//        return true
//    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId)
//        {
//            R.id.action_logout -> {
//                 SharedPref.write("isLogin",false)
//                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
//                finish()
//            }
//        }
//        return false
//    }
//}


//With MVVM//
class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofitService = RetrofitService.makeRetrofitService()
        val mainRepository = MainRepository(retrofitService)

        setSupportActionBar(binding.toolbarMain)

        viewModel = ViewModelProvider(this, MyViewModelFactory(mainRepository,this)).get(MainViewModel::class.java)

        viewModel.quoteList.observe(this, { binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            val adapter = NewsListAdapter(it)
            binding.recyclerView.adapter = adapter
        })
        viewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
        viewModel.getAllQuotes()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean { menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_logout -> {
                SharedPref.write("isLogin", false)
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                finish()
            }
        }
        return false
    }
}