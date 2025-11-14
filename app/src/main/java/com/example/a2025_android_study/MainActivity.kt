package com.example.a2025_android_study

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //xml 레이아웃을 화면에 연결
        setContentView(R.layout.activity_main)

        //3초 뒤에 온보딩 화면으로 이동하도록
        Handler(Looper.getMainLooper()).postDelayed( {
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)

            finish()
        }, 3000)
    }
}