package com.example.a2025_android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

// ViewModel

// Activity ViewModel 화면 회전해도 데이터가 유지되도록
// Fragment는 어떻게 될까요?

// ViewModel -> Activity/Fragment 공유
// Why -> Activity의 값을 Fragment 쓰고 싶거나
// Fragment에서 값을 ViewModel의 값으로 사용하기 위해서

class MainActivity : AppCompatActivity() {

//    private var countValue = 0

    lateinit var viewModel: MainViewModel
    lateinit var viewModelFactory: MainViewModelFactory

    var manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelFactory = MainViewModelFactory(5000)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        // Activity ViewModel
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//
//        Log.d("MainActivity", "onCreate")
//
//        val plusBtn : Button = findViewById(R.id.plus)
//        val minusBtn : Button = findViewById(R.id.minus)
//
//        val resultArea : TextView = findViewById(R.id.result)
//
//        plusBtn.setOnClickListener {
//            viewModel.plus()
//            resultArea.text = viewModel.countValue.toString()
//            countValue++
//            resultArea.text = countValue.toString()
//        }
//
//        minusBtn.setOnClickListener {
//            viewModel.minus()
//            resultArea.text = viewModel.countValue.toString()
//            countValue--
//            resultArea.text = countValue.toString()
//        }

        // Fragment ViewModel
//        if(savedInstanceState == null){
//            val transaction = manager.beginTransaction()
//            val fragment = TestFragment()
//            transaction.replace(R.id.frameArea, fragment)
//            transaction.addToBackStack(null)
//            transaction.commit()
//        }
    }

    override fun onStart() {
        super.onStart()

        Log.d("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.d("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.d("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.d("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("MainActivity", "onDestroy")
    }
}