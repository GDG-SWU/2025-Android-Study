package com.example.a2025_android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {





   // 2-4,5
    val manager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val transaction = manager.beginTransaction()
        val fragment = TestFragment()
        transaction.replace(R.id.frameArea, fragment)
        transaction.addToBackStack(null)
        transaction.commit()


//2-3
        //secondBtn.text= "asfsecdc"


    }
}