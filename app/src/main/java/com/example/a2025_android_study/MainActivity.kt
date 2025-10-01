package com.example.a2025_android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.a2025_android_study.databinding.ActivityMainBinding


//ViewModel
//안드로이드의 생명 주기를 관리하기 쉽다
// ViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : MainViewModel
    lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelFactory = MainViewModelFactory(5000)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

    }
}

//    val manager = supportFragmentManager

    //    var countValue = 0
//
//    init {
//        Log.d("MainViewModel", "init")
//    }
//
//    lateinit var viewModel: MainViewModel


    //12
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//
//        binding.resultArea.text = viewModel.getCount().toString()
//
//        binding.plus.setOnClickListener {
//            viewModel.plus()
//            binding.resultArea.text = viewModel.getCount().toString()
//        }
//
//        binding.minus.setOnClickListener {
//            viewModel.minus()
//            binding.resultArea.text = viewModel.getCount().toString()
//        }
//
//        val manager=supportFragmentManager
//
//        binding.showFragment.setOnClickListener{
//            val transaction = manager.beginTransaction()
//            val fragment = TestFragment()
//            transaction.replace(R.id.frameArea,fragment)
//            transaction.addToBackStack(null)
//            transaction.commit()
//        }


//        setContentView(R.layout.activity_main)

//        if (savedInstanceState==null) {
//
//            val transaction = manager.beginTransaction()
//            val fragment = TestFragment()
//            transaction.replace(R.id.frameArea, fragment)
//            transaction.addToBackStack(null)
//            transaction.commit()
//
//        }
//
//
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//
//        Log.d("MainActivity", "onCreate")
//
//        val plusBtn: Button = findViewById(R.id.plus)
//        val minusBtn: Button = findViewById(R.id.minus)
//
//        val resultArea: TextView = findViewById(R.id.result)
//
//        //이거 넣어줘야지 데이터 값 유지됨
//        resultArea.text = viewModel.countValue.toString()
//
//
//
////mainviewmodel에 있는 애들 가져옴
//        plusBtn.setOnClickListener {
//            viewModel.plus()
//            resultArea.text= viewModel.countValue.toString()
//
////            countValue++
////            resultArea.text= countValue.toString()
//        }
//
//        minusBtn.setOnClickListener {
//
//            viewModel.minus()
//            resultArea.text= viewModel.countValue.toString()
////            countValue--
////            resultArea.text= countValue.toString()
//        }
//
//
//        }
//
//
//        override fun onStart() {
//            super.onStart()
//
//            Log.d("MainActivity", "onStart")
//        }
//
//        override fun onResume() {
//            super.onResume()
//
//            Log.d("MainActivity", "onResume")
//        }
//
//        override fun onPause() {
//            super.onPause()
//
//            Log.d("MainActivity", "onPause")
//        }
//
//        override fun onStop() {
//            super.onStop()
//
//            Log.d("MainActivity", "onStop")
//        }
//
//        override fun onDestroy() {
//            super.onDestroy()
//
//            Log.d("MainActivity", "onDestroy")
//        }





