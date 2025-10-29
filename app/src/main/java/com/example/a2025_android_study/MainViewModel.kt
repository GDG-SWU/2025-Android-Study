package com.example.a2025_android_study

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap


class MainViewModel : ViewModel() {

    private var _mutableWord = MutableLiveData("")
    val liveWord : LiveData<String>
        get() = _mutableWord

    private var _randomMutableWord = MutableLiveData("")
    val randomLiveWord : LiveData<String>
        get() = _randomMutableWord

    val newData = liveWord.switchMap {
        getRandomWordShuffled(it)
    }

    init {
        getNextData()
    }

    fun getNextData(){

        val currentWord = testDataList.random()
        val randomWord = currentWord.toCharArray()
        randomWord.shuffle()

        _mutableWord.value = currentWord
        _randomMutableWord.value = String(randomWord)

    }

    fun getRandomWordShuffled(word : String) : MutableLiveData<String> {

        val liveData = MutableLiveData("")
        val randomTextWord = word.toCharArray()
        randomTextWord.shuffle()
        liveData.value = String(randomTextWord)
        return liveData

    }



    /*7//private var _mutableCount = MutableLiveData(0)
    val liveCount : LiveData<Int>
        get() = _mutableCount

    val mapLiveData = liveCount.map {
        it+it
    }

    val switchMapLiveData = liveCount.switchMap {
        changeValue(it)
    }



    fun setLiveDataValue(count : Int) {
        _mutableCount.value = count
    }

    fun changeValue(count : Int) : MutableLiveData<Int> {
        val testLiveData = MutableLiveData(count*count)
        return testLiveData
    }*/


    /*5//private var _testMutableLiveData = MutableLiveData(0)
    val testLiveData : LiveData<Int>
        get() = _testMutableLiveData

    fun plusLiveDataValue(){
        _testMutableLiveData.value = _testMutableLiveData.value!!.plus(1)
    }*/


    /*2//var testMutableLiveData = MutableLiveData(0)
    fun plusLiveDataValue(){
        testMutableLiveData.value = testMutableLiveData.value!!.plus(1)
    }*/



}