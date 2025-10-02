package com.example.a2025_android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.a2025_android_study.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

//    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : MainViewModel
    lateinit var viewModelFactory: MainViewModelFactory

    //fragment 사용하기
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = DataBinderUtil.setContentView(this,R.layout.activity_main)
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
//        val manager = supportFragmentManager
//
//        binding.showFragment.setOnClickListener {
//            val transaction = manager.beginTransaction()
//            val fragment = TestFragment()
//            transaction.replace(R.id.frameArea, fragment)
//            transaction.addToBackStack(null)
//            transaction.commit()
//        }

        setContentView(R.layout.activity_main)

        viewModelFactory = MainViewModelFactory(5000)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        //화면 전환 될 때, 다 초기화 시키는 것이 아니라 예외처리 해주는 코드
//        if(savedInstanceState == null) {

//        val transaction = manager.beginTransaction()
//        val fragment = TestFragment()
//        transaction.replace(R.id.frameArea, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()

    }
}

//        }



//    private var countValue = 0

//    lateinit var viewModel: MainViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//
//        Log.d("MainActivity", "onCreate")
//
//        val plusBtn : Button = findViewById(R.id.plus)
//        val minusBtn : Button = findViewById(R.id.minus)
//
//        val resultArea : TextView = findViewById(R.id.result)
//
//        resultArea.text= viewModel.countValue.toString()
//
//        plusBtn.setOnClickListener{
//            viewModel.plus()
//            resultArea.text= viewModel.countValue.toString()
////            countValue++
////            resultArea.text = countValue.toString()
//        }
//
//        minusBtn.setOnClickListener{
//            viewModel.minus()
//            resultArea.text= viewModel.countValue.toString()
////            countValue--
////            resultArea.text = countValue.toString()
//        }
//
//
//    }
//
//    override fun onStart() {
//        super.onStart()
//
//        Log.d("MainActivity", "onStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//
//        Log.d("MainActivity", "onResume")
//    }
//
//    override fun onPause() {
//        super.onPause()
//
//        Log.d("MainActivity", "onPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//
//        Log.d("MainActivity", "onStop")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//
//        Log.d("MainActivity", "onDestroy")
//    }


