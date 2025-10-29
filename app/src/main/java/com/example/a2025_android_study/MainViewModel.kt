package com.example.a2025_android_study

import android.view.animation.Transformation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap


class MainViewModel : ViewModel() {

    private  var _mutableWord = MutableLiveData("")
    val liveWord : LiveData<String>
        get() = _mutableWord

    private  var _randommutableWord = MutableLiveData("")
    val randomliveWord : LiveData<String>
        get() = _randommutableWord

    val newData = Transformations.switchMap(liveWord){
        getRandomWordShuffled(it)
    }

    init{
        getNextData()
    }


    fun getNextData(){
        val currentWord = testDataList.random()
        val randomWord = currentWord.toCharArray()
        randomWord.shuffle()

        _mutableWord.value = currentWord
        randomliveWord.value = String(randomWord)

    }

    fun getRandomWordShuffled(word : String) : MutableLiveData<String>{
        val liveData = MutableLiveData("")
        val randomTextWord = word.toCharArray()
        randomTextWord.shuffle()
        liveData.value = String(randomTextWord)
        return liveData
    }
}