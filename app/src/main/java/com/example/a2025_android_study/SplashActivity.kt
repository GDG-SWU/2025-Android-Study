package com.example.a2025_android_study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Looper.*

class SplashActivity : AppCompatActivity() {

    // 딜레이 시간 정의 (3000ms = 3초)
    private val SPLASH_TIME_OUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({

            val intent = Intent(this, OnboardingActivity::class.java)

            startActivity(intent)

            finish()

        }, SPLASH_TIME_OUT)
    }
}