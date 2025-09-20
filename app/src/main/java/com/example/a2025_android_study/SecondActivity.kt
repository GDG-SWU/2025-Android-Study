package com.example.a2025_android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import kotlinx.android.synthetic.main.activity_second.secondBtn

class SecondActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        secondBtn.text = "abcd"

        val transaction = manager.beginTransaction()
        val fragment = TestFragment()
        transaction.replace(R.id.frameArea, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}