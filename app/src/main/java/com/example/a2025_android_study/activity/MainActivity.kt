package com.example.a2025_android_study.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a2025_android_study.R
import com.example.a2025_android_study.ViewModel.MainViewModel
import com.example.a2025_android_study.adapter.CustomAdapter
import com.example.a2025_android_study.data.Post

// Simple Retrofit EX
// https://jsonplaceholder.typicode.com/
// https://jsonplaceholder.typicode.com/posts
// https://jsonplaceholder.typicode.com/posts/3

// 간단하게 코루틴과 / ViewModelScope

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val api = RetrofitInstance.getInstance().create(MyApi::class.java)
//
//        // 1. 유저 정보(userId)를 가져와서
//        api.getPost1().enqueue(object : Callback<Post> {
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                Log.d("API1", response.body().toString())
//
//                // 2. userId 기반으로 데이터를 가져오고 가져온 닉네임
//                api.getPostNumber(2).enqueue(object : Callback<Post> {
//                    override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                        Log.d("API2", response.body().toString())
//
//                        // 3. 닉네임 기반으로 데이터를 가져오고 유저의 댓글을 가져와서
//                        api.getPostNumber(3).enqueue(object : Callback<Post> {
//                            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                                Log.d("API3", response.body().toString())
//
//                                // 4. 유저의 댓글 기반으로, 대댓글
//                                api.getPostNumber(4).enqueue(object : Callback<Post> {
//                                    override fun onResponse(
//                                        call: Call<Post>,
//                                        response: Response<Post>
//                                    ) {
//                                        Log.d("API4", response.body().toString())
//                                    }
//
//                                    override fun onFailure(call: Call<Post>, t: Throwable) {
//                                        Log.d("API4", "fail")
//                                    }
//                                })
//                            }
//
//                            override fun onFailure(call: Call<Post>, t: Throwable) {
//                                Log.d("API3", "fail")
//                            }
//                        })
//                    }
//
//                    override fun onFailure(call: Call<Post>, t: Throwable) {
//                        Log.d("API2", "fail")
//                    }
//                })
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Log.d("API1", "fail")
//            }
//        })

        // 간단한 코루틴과 ViewModel
//        val goToSecond = findViewById<Button>(R.id.goToSecond)
//        goToSecond.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
//        }

//        Log.d("TEST", "START")
//        CoroutineScope(Dispatchers.IO).launch {
//            Log.d("TEST", "CoroutineScope START")
//            a()
//            b()
//            Log.d("TEST", "CoroutineScope END")
//        }
//        Log.d("TEST", "END")

        // START -> END -> AP1 -> BP1 -> AP2 -> BP2
//    }
//
//    suspend fun a() {
//        // a작업은 오래걸려서 2초정도
//        delay(1000)
//
//        Log.d("TEST", "AP1")
//
//        delay(1000)
//
//        Log.d("TEST", "AP2")
//    }
//
//    suspend fun b() {
//        // b 작업은 오래걸려서 2초정도
//        delay(1000)
//
//        Log.d("TEST", "BP1")
//
//        delay(1000)
//
//        Log.d("TEST", "BP2")
//    }

        // Retrofit 간단한 예제 변경
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        viewModel.getPost1()
//        viewModel.getPostNumber(3)
//        viewModel.getPostAll()
//
//        val area1 = findViewById<TextView>(R.id.area1)
//        val area2 = findViewById<TextView>(R.id.area2)
//
//        viewModel.liveWord1.observe(this, Observer {
//            area1.text = it.toString()
//        })
//
//        viewModel.liveWord2.observe(this, Observer {
//            area2.text = it.toString()
//        })
//
//        val rv = findViewById<RecyclerView>(R.id.rv)
//
//        viewModel.liveWordList.observe(this, Observer {
//            val customAdapter = CustomAdapter(it as ArrayList<Post>)
//            rv.adapter = customAdapter
//            rv.layoutManager = LinearLayoutManager(this)
//        })

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getAllData()

        val rv = findViewById<RecyclerView>(R.id.rv)

        viewModel.result.observe(this, Observer {
            val customAdapter = CustomAdapter(this, it)
            rv.adapter = customAdapter
            rv.layoutManager = LinearLayoutManager(this)
        })
    }
}