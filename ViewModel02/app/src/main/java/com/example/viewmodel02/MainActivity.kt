package com.example.viewmodel02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ViewModel02.R

// 이전 챕터에서 Activity ViewModel 화면 회전해도 데이터가 유지되도록 하였는데,
// Fragment는 어떻게 될까

class MainActivity : AppCompatActivity() {

    val manager =supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if(savedInstanceState == null) {

        val transaction = manager.beginTransaction()
        val fragment = TestFragment()
        transaction.replace(R.id.frameArea, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

//        }



    }
}