package com.example.a2025_android_study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a2025_android_study.adapter.CustomAdapter
//import com.example.a2025_android_study.model.Post
import com.example.a2025_android_study.viewModel.MainViewModel
//6//import com.example.a2025_android_study.viewModel.MainViewModel
import kotlinx.coroutines.delay
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

       //~7// lateinit var viewModel : MainViewModel

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

//7//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
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
//
//    }
//}

//6//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
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


// 5//       val goToSecond = findViewById<Button>(R.id.goToSecond)
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
//        // START -> END -> AP1 -> BP1 -> AP2 -> BP2
//
//    }
//
//    suspend fun a() {
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






//4//        val api = RetrofitInstance.getInstance().create(MyApi::class.java)
//
//        api.getPost1().enqueue(object : Callback<Post> {
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                Log.d("API1", response.toString())
//                api.getPostNumber(2).enqueue(object : Callback<Post> {
//                    override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                        Log.d("API2", response.body().toString())
//                        api.getPostNumber(3).enqueue(object : Callback<Post> {
//                            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                                Log.d("API3", response.body().toString())
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
//    }
//}




//3/        api.getPostNumber(2).enqueue(object : Callback<Post> {
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
//
//    }
