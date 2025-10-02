package com.example.androidview03

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androidview03.databinding.ActivityMainBinding

//DataBinding
// ViewBinding 이랑 뭐가 다른가?
// 이름처럼 데이터를 연결해주는 역할을 할 수 있습니다. (데이터와 같이 결합해서 사용할 수 있음)

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //데이터 바인딩을 이용해서 view에 접근하여 text를 바꿈
        binding.dataBindingEx.text= "바뀐 텍스트"
        binding.dataBindingEx.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent) //클릭하면 SecondActivity가 뜨도록 함
        }

    }
}