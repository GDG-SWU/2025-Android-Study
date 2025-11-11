package com.example.a2025_android_study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

//MainActivity.kt
class MainActivity : AppCompatActivity() {

    //onCreate는 이 화면(Activity)이 처음 만들어질 때 딱 한 번 실행되는
    //가장 중요하고 기본적인 함수임
    override fun onCreate(savedInstanceState: Bundle?) {

        //필수!!  부모 클래스(AppCompatActivity)의 onCreate 함수를 먼저 실행하라는 뜻
        super.onCreate(savedInstanceState)

        //setContentView는 이 코틀린 파일과 짝이 되는 XML 파일을
        //연결하라는 매우 중요한 명령임. R.layout.activity_main은
        //res/layout/activity_main.xml 파일을 가리킴.
        setContentView(R.layout.activity_main)

        //아래에 만든 settingButton 함수를 실행하라는 명령어
        //onCreate가 너무 복잡해지지 않게, 버튼 관련 설정은 따로 빼서 정리한 것
        settingButton()
    }


    //버튼 관련 설정을 모아둔 함수 (직접 만듦)
    fun settingButton() {

        //findViewById는 xml에 있는 view를 코틀린에서 쓸 수 있게 id 값으로 찾아오는 검색 기능임
        //<Button>은 버튼 타입으로 찾아오라는 뜻이고
        //R.id.button은 activity_main.xml 파일에 있는 id가 "button"인 뷰를 찾아오라는 뜻
        val button = findViewById<Button>(R.id.button)

        //setOnClickListener는 이 버튼이 클릭 되었을 때 어떤 동작을 할 지 정하는 부분
        //중괄호 안에 있는 내용이 버튼 클릭 시 실행됨
        button.setOnClickListener {

            //Intent는 다른 액티비티(화면)로 이동하기 위한 경로라고 생각하면 됨
            //this(여기)에서 SubActivity로 가는 경로를 만드는 것
            val intent = Intent(this,SubActivity::class.java)

            //startActivity는 위에서 만든 intent 경로를 사용하여
            //실제로 SubActivity 화면을 띄우라는 명령임
            startActivity(intent)
        }
    }
}