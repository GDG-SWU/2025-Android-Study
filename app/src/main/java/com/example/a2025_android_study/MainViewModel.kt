package com.example.a2025_android_study

import android.util.Log
import androidx.lifecycle.ViewModel

//ViewModelFactory
//Repository / 네트워크 통신을 하거나 / LocalDB / Room SQLite 등에서 데이터를 받아오는 코드를
//ViewModel에서 사용할 수도 있음. 이 값들을 넘겨주고 싶을 때, ViewModelFactory를 사용하게 되는 것!


//ViewModel에서 저렇게 아래와 같이 변수 하나만 만들어서 사용하지는 않고
//LiveData 등을 이용해서 함께 씀! 아래는 그저 참고용 예제로만 보기

class MainViewModel(num : Int) : ViewModel() {

//    var countValue = 0

    init {
        Log.d("MainViewModel", num.toString())
    }

//    fun plus(){
//        countValue++
////        Log.d("MainViewModel", countValue.toString())
//    }
//
//    fun minus(){
//        countValue--
////        Log.d("MainViewModel", countValue.toString())
//    }
//
//    fun getCount() : Int {
//        return countValue
//    }
//
}