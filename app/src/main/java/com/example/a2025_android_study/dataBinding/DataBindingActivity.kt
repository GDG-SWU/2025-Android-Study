package com.example.a2025_android_study.dataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a2025_android_study.R
import com.example.a2025_android_study.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    //Data Binding Activity에 CustomDataAdapter 연결하기
    private lateinit var binding : ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)

        //setContentView(R.layout.activity_data_binding)

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
        array.add("a")
        array.add("b")
        array.add("c")

        val customDataAdapter = CustomDataAdapter(array)

        val rv = binding.rv
        rv.adapter= customDataAdapter
        rv.layoutManager= LinearLayoutManager(this)

    }
}