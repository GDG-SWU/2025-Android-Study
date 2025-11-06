package com.example.a2025_android_study

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.example.a2025_android_study.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

//    val manager = supportFragmentManager
    private lateinit var viewModel : MainViewModel

    //private var testMutableLiveData = MutableLiveData(0)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.vm = viewModel
        binding.lifecycleOwner = this

        binding.next.setOnClickListener {
            viewModel.getNextData()
        }

    }


//        binding = ActivityMainBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//
//        binding.btn1.setOnClickListener {
//            val transaction1 = manager.beginTransaction()
//            val fragment1 = BlankFragment1()
//            transaction1.replace(R.id.frameArea, fragment1)
//            transaction1.addToBackStack(null)
//            transaction1.commit()
//        }
//
//        binding.btn2.setOnClickListener {
//            val transaction2 = manager.beginTransaction()
//            val fragment2 = BlankFragment2()
//            transaction2.replace(R.id.frameArea, fragment2)
//            transaction2.addToBackStack(null)
//            transaction2.commit()
//        }

//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//
//        findViewById<Button>(R.id.btnArea).setOnClickListener {
//            viewModel.plusLiveDataValue()
//        }
//
//        viewModel.testLiveData.observe(this, {
//            findViewById<TextView>(R.id.textArea).text = it.toString()
//        })

        //아래 코드에 대해 빨간불이 뜨게됨
        //viewModel.testLiveData.value = 10

        //처름과는 달리, 회전했을 때에도 값이 유지되는 것을 볼 수 있음
//        findViewById<Button>(R.id.btnArea).setOnClickListener {
//            //testMutableLiveData.value = testMutableLiveData.value!!.plus(1)
//
//            viewModel.plusLiveDataValue()
//        }
//
//        //올라가는 것을 관찰하기 위해 observer 사용해 로그 찍기
////        testMutableLiveData.observe(this, {
////            Log.d("testMutableLiveData", testMutableLiveData.value.toString())
////            //값이 올라갈 때마다 위 코드가 실행됨
////            findViewById<TextView>(R.id.textArea).text = testMutableLiveData.value.toString()
////        })
//
//        viewModel.testMutableLiveData.observe(this,) {
//            //findViewById<TextView>(R.id.textArea).text = viewModel.testMutableLiveData.value.toString()
//            findViewById<TextView>(R.id.textArea).text = it.toString() //위와 같음!
//        }
//
//        viewModel.testMutableLiveData.value = 10

}


