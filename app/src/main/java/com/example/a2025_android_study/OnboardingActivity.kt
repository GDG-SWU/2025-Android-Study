package com.example.a2025_android_study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        // 1. XML에 있는 버튼을 변수로 가져오기
        val getStartedButton = findViewById<Button>(R.id.btn_get_started)

        // 2. 버튼 클릭 리스너 설정
        getStartedButton.setOnClickListener {
            // HomeActivity로 이동하는 Intent 생성
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

            // OnboardingActivity는 종료
            finish()
        }
    }
}