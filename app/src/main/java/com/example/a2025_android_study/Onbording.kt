package com.example.a2025_android_study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton


class Onbording : AppCompatActivity() {

    //Get Started 버튼을 클릭했을 때 HomeScreen으로 넘어가도록
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onbording)//레이아웃 연결

        //레이아웃에서 버튼을 찾아 연결 (ID는 반드시 XML과 일치해야 함)
        val getStartedButton: ImageButton = findViewById(R.id.getStartedButton) // XML의 버튼 ID와 연결

        //버튼 클릭 이벤트 설정
        getStartedButton.setOnClickListener {
            // HomeScreen으로 이동할 Intent 생성
            val intent = Intent(this, HomeScreen::class.java)
            //화면 전환 시작
            startActivity(intent)
            finish() // Onbording 닫기
        }
    }
}