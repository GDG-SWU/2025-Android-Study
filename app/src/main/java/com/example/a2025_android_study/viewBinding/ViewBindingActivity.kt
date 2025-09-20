package com.example.a2025_android_study.viewBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a2025_android_study.CustomAdapter
import com.example.a2025_android_study.R
import com.example.a2025_android_study.databinding.ActivityViewBindingBinding

class ViewBindingActivity : AppCompatActivity() {

    private lateinit var binding : ActivityViewBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewBindingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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

        val customViewAdapter = CustomViewAdapter(array)

        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.adapter = customViewAdapter
        rv.layoutManager = LinearLayoutManager(this)
    }
}