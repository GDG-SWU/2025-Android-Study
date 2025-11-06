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

//
//    // Transformations -> map / switchMap
//
//    // map -> 값을 return
//
//    private var _mutableCount = MutableLiveData(0)
//    val liveCount : LiveData<Int>
//        get() = _mutableCount
//
//    val mapLiveData = liveCount.map {
//        it+it
//    }
//
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

//    private var _testMutableLiveData = MutableLiveData(0)
//    val testLiveData : LiveData<Int>
//        get() = _testMutableLiveData
//
//    //15강과의 차이점은 testLiveData의 존재임
//    //15강에서는 뷰모델의 testMutableLiveData를 관찰했다면, 이번에는
//    //위에 있는 testLiveData를 관찰
//
//    fun plusLiveDataValue() {
//        _testMutableLiveData.value = _testMutableLiveData.value!!.plus(1)
//    }

//    var testMutableLiveData = MutableLiveData(0)
//
//    //MutableLiveData와 LiveData는 다른 것임!
//
//    fun plusLiveDataValue() {
//        testMutableLiveData.value = testMutableLiveData.value!!.plus(1)
//    }
}

