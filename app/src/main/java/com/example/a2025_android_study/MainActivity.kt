package com.example.a2025_android_study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.example.a2025_android_study.databinding.ActivityMainBinding
//import kotlinx.android.synthetic.main.activity_main.btn1
//import kotlinx.android.synthetic.main.activity_main.btn2
//import kotlinx.android.synthetic.main.activity_main.btn3
//import kotlinx.android.synthetic.main.activity_second.secondBtn

// findViewById
// Kotlin Extensions

// ViewBinding
    // Activity
    // Fragment
// DataBinding
    // ViewBinding이랑 다른점: 이름처럼 데이터를 연결해주는 역할(데이터와 같이 결합해서 사용 가능)
    // DataBinding + LiveData
    // 데이터 결합

// ViewBinding DataBinding
// RecyclerView Adapter findViewById

// DataBinding + ViewModel + LiveData

class MainActivity : AppCompatActivity() {

//    private lateinit var binding : ActivityMainBinding  // 바인딩 객체 선언
//
//    var testCount = 23

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adapter + ViewBinding
        val array = ArrayList<String>()

        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")

        val customAdapter = CustomAdapter(array)

        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.adapter = customAdapter
        rv.layoutManager = LinearLayoutManager(this)

//        // DataBinding 초기화
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//
//        // 데이터 결합
//        val person = Person("채서린", 23)
//        binding.user = person

        // 바인딩 객체를 통해 뷰 접근 및 데이터 적용
//        binding.dataBindingEx.text = "바뀐 텍스트"
//        binding.dataBindingEx.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
//        }

        // findViewById -> 100개
//        val btn1 : Button = findViewById(R.id.btn1)
//        val btn2 : Button = findViewById(R.id.btn2)
//        val btn3 : Button = findViewById(R.id.btn3)
//
//        btn1.text = "abcd"
//        btn2.text = "abc"
//        btn3.text = "ab"

        // Kotlin Extensions -> 구글에서는 권장 x + 성능 이슈
//        btn1.text = "abcd"
//        btn2.text = "abc"
//        btn3.text = "ab"

        // 작성은 가능한데 실행하게 되면 오류 발생
//        secondBtn.text = "sjdkflsdjf" // // MainActivity에서 SecondActivity 버튼 접근 시 오류

        // ViewBinding
//        binding = ActivityMainBinding.inflate(layoutInflater)   // 바인딩 초기화
//        // 루트 뷰 설정
//        val view = binding.root
//        setContentView(view)
//
//        // 뷰 사용
//        binding.testText.text = "변경된 텍스트"
//        binding.testText.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
//        }
    }

//    fun myClick(view : View){
//        Log.d("MainActivity", "onClick")
//        testCount++
//
//        val person = Person("채서린", testCount)
//        binding.user = person
//    }
}