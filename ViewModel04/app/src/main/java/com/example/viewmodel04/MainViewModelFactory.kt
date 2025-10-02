package com.example.viewmodel04

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//숫자 데이터를 넘겨주는 예제
class MainViewModelFactory(private val num : Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(num) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}