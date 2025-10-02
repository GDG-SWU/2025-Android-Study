package com.example.viewmodel04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

// ViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : MainViewModel
    lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelFactory = MainViewModelFactory(5000) //설정한 값을 넘겨줌
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

    }
}