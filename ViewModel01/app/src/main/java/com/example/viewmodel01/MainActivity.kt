package com.example.viewmodel01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

// ViewModel

// 1 - https://developer.android.com/topic/libraries/architecture/viewmodel#coroutines
// 2 - https://developer.android.com/guide/components/activities/activity-lifecycle?hl=ko

// ViewModel 요약
// 안드로이드의 생명 주기를 관리하기 쉽다.
// onSaveInstanceState() 사용해서 데이터를 관리할 수 있지만 적절하지 않다.
// UI컨트롤러(Activity, Fragment)에서 모든 것을 다 하려고 하면 복잡해진다.
// 그래서 ViewModel 을 사용하면 테스트나 관리가 용이하다.

class MainActivity : AppCompatActivity() {

    // private var countValue = 0
    lateinit var viewModel: MainViewModel //ViewModel 사용하기 위함

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        Log.d("MainActivity", "onCreate")

        val plusBtn : Button = findViewById(R.id.plus)
        val minusBtn : Button = findViewById(R.id.minus)

        val resultArea : TextView = findViewById(R.id.result)

        //화면 회전 시에도 결과값 정상 표기 위함
        resultArea.text= viewModel.countValue.toString()

        //버튼에 따라 countValue 값 변화
        plusBtn.setOnClickListener{
            viewModel.plus()
            resultArea.text= viewModel.countValue.toString()
//            countValue++
//            resultArea.text= countValue.toString()
        }

        minusBtn.setOnClickListener{
            viewModel.minus()
            resultArea.text= viewModel.countValue.toString()
//            countValue--
//            resultArea.text= countValue.toString()
        }


    }

    //라이프사이클(생명주기) 보기 위해 로그 찍기
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