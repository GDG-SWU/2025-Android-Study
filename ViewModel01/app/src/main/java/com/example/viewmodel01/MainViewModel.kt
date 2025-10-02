package com.example.viewmodel01

import android.util.Log
import androidx.lifecycle.ViewModel

// 보통 ViewModel에서 아래와 같이 변수 하나만 생성하여 사용하지는 않고 LiveData등을 이용하여 함께 씀
// 예제로만 참고할 것

class MainViewModel : ViewModel() {

    var countValue = 0

    init {
        Log.d("MainViewModel", "init")
    }

    // plus minus function 생성, countValue 로그 찍어보기
    fun plus(){
        countValue++
        Log.d("MainViewModel", countValue.toString())
    }

    fun minus(){
        countValue--
        Log.d("MainViewModel", countValue.toString())
    }

    fun getCount() : Int {
        return countValue
    }

}