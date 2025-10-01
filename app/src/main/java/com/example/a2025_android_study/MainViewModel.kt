package com.example.a2025_android_study

import android.util.Log
import androidx.lifecycle.ViewModel


class MainViewModel(num : Int) : ViewModel() {

    init {
        Log.d("MainViewModel", num.toString())
    }
    }
