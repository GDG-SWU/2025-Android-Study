package com.example.a2025_android_study

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap

class MainViewModel : ViewModel() {

//    var testMutableLiveData = MutableLiveData(0)
//
//    fun plusLiveDataValue(){
//        testMutableLiveData.value = testMutableLiveData.value!!.plus(1)
//    }

    // Transformations -> map / switchMap

    // map -> 값을 return

//    private var _mutableCount = MutableLiveData(0)
//    val liveCount : LiveData<Int>
//        get() = _mutableCount
//
//    // map 확장 함수 사용
//    val mapLiveData = liveCount.map {
//        it + it
//    }
//
//    // switchMap 확장 함수 사용
//    val switchMapLiveData = liveCount.switchMap {
//        changeValue(it)
//    }
//
//    fun setLiveDataValue(count : Int) {
//        _mutableCount.value = count
//    }
//
//    fun changeValue(count : Int) : MutableLiveData<Int> {
//        val testLiveData = MutableLiveData(count*count)
//        return testLiveData
//    }

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
}