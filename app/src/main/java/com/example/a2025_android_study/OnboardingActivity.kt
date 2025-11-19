package com.example.a2025_android_study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //activity_onboarding.xml을 사용자에게 보여주기
        setContentView(R.layout.activity_onboarding)

        //1. xml에 있는 버튼 (R.id.btn.get_started)을 찾아서
        //코틀린 변수인 getStartedButton에 연결
        val getStartedButton = findViewById<Button>(R.id.btn_get_started)

        //2. 사용자가 버튼을 클릭 할 때까지 기다림.
        //클리하는 순간, { } 안의 코드 실행
        getStartedButton.setOnClickListener {
            // HomeActivity로 이동하는 Intent 생성
            val intent = Intent(this, HomeActivity::class.java)

            //실제로 화면을 HomeActivity로 전환시키기
            startActivity(intent)

            //OnboardingActivity는 메모리에서 없애기
            finish()
        }
    }
}