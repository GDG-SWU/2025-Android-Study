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




class MainActivity : AppCompatActivity() {

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


        val customAdapter = CustomAdapter(array)

        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.adapter= customAdapter
        rv.layoutManager= LinearLayoutManager(this)

    }
}





//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding : ActivityMainBinding
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//


    //        //2-6
//        //데이터 결합
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)



//        val person = Person("개복치", 20)
//        binding.user = person
//    }
//
//        var testCount=20
//
//        fun myClick(view : View) {
//            Log.d("MainActivity", "onClick")
//            testCount++
//
//            val person = Person("개복치", testCount)
//            binding.user= person







//        2-5
//        binding.dataBindingEx.text="바뀐 덱스트"
//        binding.dataBindingEx.setOnClickListener{
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
//        }

        //setContentView(R.layout.activity_main)


//        sec2-4
//        binding= ActivityMainBinding.inflate(layoutInflater)
//        val view = binding.root
//        //setContentView(R.layout.activity_main)
//        setContentView(view)
//
//        binding.testText.text ="이거는 변경된 텍스트"
//        binding.testText.setOnClickListener{
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
//        }


//sec2-3
//        val btn1 : Button = findViewById(R.id.btn1)
//        val btn2 : Button = findViewById(R.id.btn2)
//        val btn3 : Button = findViewById(R.id.btn3)
//
//        btn1.text = "abcd"
//        btn2.text = "abcd"
//        btn3.text = "abcd"
//
//         Kotlin Extensions
//        btn1.text = "abcd"
//        btn2.text = "abcd"
//        btn3.text = "abcd"





//    }
//}