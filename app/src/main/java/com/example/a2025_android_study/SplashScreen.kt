package com.example.a2025_android_study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log

// 3초 후 Onbording으로 자동으로 넘어가도록
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen) //레이아웃 파일 연결

        // Handler를 사용하여 3초(3000ms) 후 실행
        Handler(Looper.getMainLooper()).postDelayed({

            // Onbording으로 이동할 Intent 생성
            val intent = Intent(this, Onbording::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            //화면 전환
            startActivity(intent)
            finish() // 현재화면(SplashScreen) 닫아서 뒤로가기를 눌러도 돌아오지 않게 함
        }, 3000) // 3000ms = 3초 딜레이
    }
}