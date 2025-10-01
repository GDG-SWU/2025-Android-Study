package com.example.a2025_android_study

import androidx.lifecycle.ViewModel

class TestFragmentViewModel : ViewModel() {

    var countvalue = 0

    fun plus(){
        countvalue++
    }

    fun minus(){
        countvalue--
    }
    fun getCount() : Int {
        return countvalue
    }


}