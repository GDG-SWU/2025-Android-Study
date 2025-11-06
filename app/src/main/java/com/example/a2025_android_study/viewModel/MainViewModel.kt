package com.example.a2025_android_study.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a2025_android_study.api.MyAPI
import com.example.a2025_android_study.model.Plant
import com.example.a2025_android_study.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = Repository()

    private val _result = MutableLiveData<List<Plant>>()
    val result : LiveData<List<Plant>>
        get() = _result

    fun getAllData() = viewModelScope.launch {
        Log.d("MainViewModel", repository.getAllData().toString())
        _result.value = repository.getAllData()
    }

}