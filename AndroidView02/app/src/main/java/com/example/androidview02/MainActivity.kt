package com.example.androidview02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidview02.databinding.ActivityMainBinding
import android.content.Intent

// ViewBinding
// Activity
// Fragment

// https://developer.android.com/topic/libraries/view-binding?hl=ko


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //binding에서 text에 다이렉트로 접근
        binding.testText.text= "이거는 변경된 텍스트"
        binding.testText.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent) //클릭하면 세컨트 엑티비티로 넘어가도록 함
        }
    }
}