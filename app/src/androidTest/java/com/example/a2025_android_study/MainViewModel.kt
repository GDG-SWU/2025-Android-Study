package com.example.a2025_android_study

import androidx.lifecycle.ViewModel


//ViewModel에서 저렇게 아래와 같이 변수 하나만 만들어서 사용하지는 않고
//LiveData 등을 이용해서 함께 씀! 아래는 그저 참고용 예제로만 보기
class MainViewModel : ViewModel() {

    var countValue = 0

    fun plus() {
        countValue++
    }

    fun minus() {
        countValue--
    }

    fun getCount() : Int {
        return countValue
    }
}