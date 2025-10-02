package com.example.androidview01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// findViewById
// Kotlin Extensions
// https://thdev.tech/android/2020/10/07/Remove-kotlinx-synthetic/
// https://junyoung-developer.tistory.com/27
// ViewBinding(구글 권장)
// DataBinding(구글 권장)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        // findViewById -> 100개(복잡해짐)
//        val btn1 : Button = findViewById(R.id.btn1)
//        val btn2 : Button = findViewById(R.id.btn2)
//        val btn3 : Button = findViewById(R.id.btn3)
//
//        btn1.text = "abcd" // 버튼 텍스트 변경
//        btn2.text = "abcd"
//        btn3.text = "abcd"

        // Kotlin Extensions
       // btn1.text = "abcd"
       // btn2.text = "abcd"
       // btn3.text = "abcd"

        //secondBtn.text = "sadfasdfasdf" //착각해서 칠 경우 문제 생김

    }
}