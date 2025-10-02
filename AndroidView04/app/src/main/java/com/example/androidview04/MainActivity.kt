package com.example.androidview04

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.androidview04.databinding.ActivityMainBinding


// DataBinding(데이터 결합)
// 이름처럼 뭔가 데이터를 연결해줄 수 없을까?

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding //데이터바인딩 할 수 있게 선언

    var testCount = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // 기존의 방법
        // binding.test.text = "바뀐 텍스트"

        // 데이터 결합(기존과 조금 다른 방식)
        val person = Person("개복치", 20)
        binding.user= person
    }

    fun myClick(view : View) {
        Log.d("MainActivity", "onClick")
        testCount++ //버튼이 눌릴때마다 testCount 증가

        val person = Person("개복치", testCount)
        binding.user= person

    } //버튼에 function을 연결하여 사용
}