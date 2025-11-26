package com.example.a2025_android_study

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //activity_main.xml을 화면에 연결해서 유저에게 보여주기
        setContentView(R.layout.activity_main)

        //3초 동안 실행 멈추고 기다리기
        Handler(Looper.getMainLooper()).postDelayed( {

            //3초 후에, OnboardingActivity를 시작하기 위한 요청을 생성
            val intent = Intent(this, OnboardingActivity::class.java)

            //OnboardingActivity로 실제로 이동하기
            startActivity(intent)

            //MainActivity를 메모리에서 제거하기
            finish()
        }, 3000)
    }
}