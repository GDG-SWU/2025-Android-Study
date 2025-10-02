package com.example.viewmodel02

import androidx.lifecycle.ViewModel

class TestFragmentViewModel : ViewModel() {

    var countValue = 0

    fun plus(){
        countValue++
    }

    fun minus(){
        countValue--
    }

    //count값을 가져옴
    fun getCount() : Int{
        return countValue
    }

}