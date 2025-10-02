package com.example.viewmodel03

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var countValue = 0

    //plus minus 버튼에 따른 값 변화
    fun plus() {
        countValue++
    }

    fun minus() {
        countValue--
    }

    fun getCount() : Int {
        return countValue
    }

}