package com.example.a2025_android_study

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel4 : ViewModel(){

    private var _testMutableLiveData = MutableLiveData(0)
    val testLiveData : LiveData<Int>
        get() = _testMutableLiveData

    fun plusLiveDataValue(){
        _testMutableLiveData.value = _testMutableLiveData.value!!.plus(1)

    }



//    var testMutableLiveData = MutableLiveData(0)
//
//    fun plusLiveDataValue(){
//        testMutableLiveData.value = testMutableLiveData.value!!.plus(1)
    }