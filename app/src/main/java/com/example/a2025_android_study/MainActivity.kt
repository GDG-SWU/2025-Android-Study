package com.example.a2025_android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.a2025_android_study.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    var testCount = 20
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val person = Person("념념",20)
        binding.hyun = person

    }

    fun myClick(view : View){
        Log.d("MainActivity", "onClick")
        testCount++

        val person = Person("념념",testCount)
        binding.hyun = person
    }
}
