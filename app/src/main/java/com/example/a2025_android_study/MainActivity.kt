package com.example.a2025_android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager



//import androidx.databinding.DataBindingUtil
//import com.example.a2025_android_study.databinding.ActivityMainBinding
//import android.view.View
//import android.util.Log

//import android.content.Intent

//뷰바인딩을 위한 임포트
//import com.example.a2025_android_study.databinding.ActivityMainBinding

//import android.widget.Button
//import kotlinx.android.synthetic.main.activity_main.btn1
//import kotlinx.android.synthetic.main.activity_main.btn2
//import kotlinx.android.synthetic.main.activity_main.btn3



//findViewById
//findViewById의 불편함을 해소하기 위해 나온것이 Kotlin Extensions
//구글에서는 뷰 바인딩과 데이터 바인딩을 사용하라고 권장하고 있음
//ViewBinding
    //Activity에서 사용하는 방법
    //Fragment에서 사용하는 방법

//DataBinding
    //ViewBinding과 무엇이 다른가? -> 이름처럼 데이터를 연결해주는 역할을 할 수 있음 (데이터와 같이 결합해서 사용 가능)

class MainActivity : AppCompatActivity() {

    //데이터 바인딩 가능하도록 선언
    //private lateinit var binding : ActivityMainBinding
    //var testCount = 24


    //뷰바인딩 쓰기
    //private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        rv.adapter= customAdapter
        rv.layoutManager= LinearLayoutManager(this)


        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //데이터바인딩 - 데이터 결합
        //val person = Person("연지", 24)
        //binding.user = person
    }

    //fun myClick(view : View) {
    //    Log.d("MainActivity", "onClick")
    //    testCount++
    //
    //    val person = Person("연지", testCount)
    //    binding.user = person
    //}
        //기존 데이터 바인딩 방법은 아래와 같음
        //뷰 바인딩과 다를바가 없음
        //binding.dataBindingEx.text = "바뀐 텍스트"
        //binding.dataBindingEx.setOnClickListener {
        //    val intent = Intent(this, SecondActivity::class.java)
        //    startActivity(intent)
        //}


        //뷰 바인딩 (Activity) 쓰기
        //binding = ActivityMainBinding.inflate(layoutInflater)
        //val view = binding.root
        //setContentView(view)

        //binding.testText.text = "이것은 변경된 텍스트"

        //binding.testText.setOnClickListener {
        //    val intent = Intent(this, SecondActivity::class.java)
        //    startActivity(intent)
        //}
        //여기까지 뷰 바인딩 (Activity) 사용한 방법

        //setContentView(R.layout.activity_main)

        //findViewById를 사용한 코드. 갯수가 많아지면 복잡&가독성 저하
        //val btn1 : Button = findViewById(R.id.btn1)
        //val btn2 : Button = findViewById(R.id.btn2)
        //val btn3 : Button = findViewById(R.id.btn3)

        //btn1.text = "abcd"
        //btn2.text = "abcd"
        //btn3.text = "abcd"

        //Kotlin Extensions를 사용하는 방법 : fineViewById를 지우고 접근 가능
        //하지만 권장 되는 방식은 아님.
        //btn1.text = "abcd"
        //btn2.text = "abcd"
        //btn3.text = "abcd"

        //왜? 만약 SecondActivity에서 입력해야 할 코드를 MainActivity에서 입력하게되면
        //앱이 죽어버리게 됨 + 성능 이슈도 있음
        //secondBtn.text = "abcdefj"
}