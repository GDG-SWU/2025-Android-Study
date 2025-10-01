package com.example.a2025_android_study

import android.util.Log
import androidx.lifecycle.ViewModel

// ViewModel에서 저렇게 아래와 같이 변수 하나만 만들어서
// 사용하지는 않고 LiveDate등등)을 이용해서 함께 씀
// 아래는 예제니까 참고

class MainViewModel(num : Int) : ViewModel() {

    var countValue = 0

    init {
        Log.d("MainViewModel", num.toString())
    }

    // Repository
    // 네트워크 통신을 하거나

    // LocalDB
    // Room SQLite

    init {
        Log.d("MainViewModel", "init")
    }

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