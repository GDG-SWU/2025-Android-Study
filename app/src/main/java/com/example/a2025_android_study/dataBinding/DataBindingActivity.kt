package com.example.a2025_android_study.dataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a2025_android_study.R
import com.example.a2025_android_study.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDataBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)

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

        val customViewAdapter = CustomDataAdapter(array)

        val rv = binding.rv
        rv.adapter= customViewAdapter
        rv.layoutManager= LinearLayoutManager(this)
        //setContentView(R.layout.activity_data_binding)
    }
}