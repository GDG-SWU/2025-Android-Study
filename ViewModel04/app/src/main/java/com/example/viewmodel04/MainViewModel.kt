package com.example.viewmodel04

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel(num : Int) : ViewModel() {

    //num 로그 찍기
    init {
        Log.d("MainViewModel", num.toString())
    }

    // Repository 네트워크 통신 LocalDB Room SQLite 등등
    // 이런것들에서 데이터를 받아오는 코드를 뷰모델에서 사용할 경우
    // 값을 뷰모델에 넘겨줄 때 사용

}