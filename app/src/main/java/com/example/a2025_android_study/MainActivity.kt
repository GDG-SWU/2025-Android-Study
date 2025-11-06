package com.example.a2025_android_study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a2025_android_study.adapter.CustomAdapter
import com.example.a2025_android_study.api.MyApi
import com.example.a2025_android_study.api.RetrofitInstance
import com.example.a2025_android_study.model.Plant
import com.example.a2025_android_study.viewModel.MainViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Simple Retrofit Ex
// https://jsonplaceholder.typicode.com/


//23,24강. 레트로핏 예제
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val api = RetrofitInstance.getInstance().create(MyApi::class.java)
//        api.getPost1().enqueue(object : Callback<Post> {
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                Log.d("API1", response.body().toString())
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Log.d("API1", "fail")
//            }
//
//        })
//
//        api.getPostNumber(2).enqueue(object : Callback<Post> {
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                Log.d("API2", response.body().toString())
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Log.d("API2", "fail")
//            }
//
//        })
//
//    }
//}




//25강.callbackhell

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val api = RetrofitInstance.getInstance().create(MyApi::class.java)
//        //1안에 2,2안에 3... 이런식으로 하면 내가 원하는 순서대로 호출할 수 있음
//        //그냥 나열하면 비동기적으로 실행되어 오래걸리는 거는 나중에 실행 됨 (순서 불규칙)
//        //1,2,3,4 아래처럼 순서가 정해져있으면 이렇게 하면 됨
//
//        // 1. 유저 정보를 가져와서 (userId)
//        api.getPost1().enqueue(object : Callback<Post> {
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                Log.d("API1", response.body().toString())
//
//                // 2. userId 기반으로 데이터를 가져오고 가져온 닉네임값
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
//                                    override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                                        Log.d("API4", response.body().toString())
//                                    }
//
//                                    override fun onFailure(call: Call<Post>, t: Throwable) {
//                                        Log.d("API4", "fail")
//                                    }
//
//                                })
//                            }
//
//                            override fun onFailure(call: Call<Post>, t: Throwable) {
//                                Log.d("API3", "fail")
//                            }
//
//                        })
//                    }
//
//                    override fun onFailure(call: Call<Post>, t: Throwable) {
//                        Log.d("API2", "fail")
//                    }
//
//                })
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Log.d("API1", "fail")
//            }
//
//        })
//
//
//
//    }
//}




// 간단하게 코루틴과 / ViewModelScope
// https://developer.android.com/kotlin/coroutines?hl=ko

// https://myungpyo.medium.com/reading-coroutine-official-guide-thoroughly-part-0-20176d431e9d

//26. viewmodelscope
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val goToSecond = findViewById<Button>(R.id.goToSecond)
//        goToSecond.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
//        }
//
////        Log.d("TEST", "START")
////        CoroutineScope(Dispatchers.IO).launch {
////            Log.d("TEST", "CoroutineScope START")
////            a()
////            b()
////            Log.d("TEST", "CoroutineScope END")
////        }
////        Log.d("TEST", "END")
//
//        // START -> END -> AP1(혹은 BP1) -> BP1 -> AP2 -> BP2 (A와B중 하나 먼저 실행됨)
//
//    }
//
//    suspend fun a() {
//        //시간지연하기
//
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
//
//        // b 작업은 오래걸려서 2초정도
//        delay(1000)
//
//        Log.d("TEST", "BP1")
//
//        delay(1000)
//
//        Log.d("TEST", "BP2")
//
//    }
//
//}
//



//27강
//class MainActivity : AppCompatActivity() {
//
//    lateinit var viewModel : MainViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        viewModel.getPost1()
//        viewModel.getPostNumber(3)
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
//    }
//}


//28강
// https://raw.githubusercontent.com/googlecodelabs/kotlin-coroutines/master/advanced-coroutines-codelab/sunflower/src/main/assets/plants.json

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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