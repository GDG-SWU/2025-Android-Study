package com.example.a2025_android_study

import android.util.Log
import androidx.lifecycle.ViewModel

//ViewModel에서 저렇게 아래와 같이 딸랑 변수 하나만 만들어서
//사용하지는 ㅇ낳고 LiveData을 이용해서 함께 씀
//아래는 예제, 참거ㅁ만


//repository나 localdb 정보를 뷰모델에서 사용하고 싶을 때

class MainViewModel(num : Int) : ViewModel() {

    init {
        Log.d("MainViewModel", num.toString())
    }

    // Repository
    // 네트워크 통신을 하거나

    // LocalDB
    // Room SQLite

}


//12
//class MainViewModel : ViewModel() {
//
//    var countValue=0
//    init {
//        Log.d("MainViewModel", "init")
//    }
//
//    fun plus(){
//        countValue++
//        Log.d("MainViewmodel", countValue.toString())
//    }
//
//    fun minus(){
//        countValue--
//        Log.d("MainViewmodel", countValue.toString())
//    }
//
//    fun getCount() : Int{
//        return countValue
//    }
//}