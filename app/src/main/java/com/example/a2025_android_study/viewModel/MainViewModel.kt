package com.example.a2025_android_study.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a2025_android_study.api.MyApi
import com.example.a2025_android_study.api.RetrofitInstance
import com.example.a2025_android_study.model.Plant
import com.example.a2025_android_study.model.Post
import com.example.a2025_android_study.repository.Repository
import kotlinx.coroutines.launch


//27강.
//class MainViewModel : ViewModel() {
//
//    private val retrofitInstance = RetrofitInstance.getInstance().create(MyApi::class.java)
//
//    private var _mutableWord1 = MutableLiveData<String>()
//    val liveWord1 : LiveData<String>
//        get() = _mutableWord1
//
//    private var _mutableWord2 = MutableLiveData<String>()
//    val liveWord2 : LiveData<String>
//        get() = _mutableWord2
//
//    fun getPost1() = viewModelScope.launch {
//
//        val post = retrofitInstance.getPost1()
//        Log.d("MainViewModel", post.toString())
//        _mutableWord1.value = post.title
//
//    }
//
//    fun getPostNumber(number : Int) = viewModelScope.launch {
//        val post = retrofitInstance.getPostNumber(number)
//        Log.d("MainViewModel", post.toString())
//        _mutableWord2.value = post.title
//    }
//
//
//}


//27강
//class MainViewModel : ViewModel() {
//
//    private val retrofitInstance = RetrofitInstance.getInstance().create(MyApi::class.java)
//
//
//    //라이브데이터
//
//    private var _mutableWord1 = MutableLiveData<String>()
//    val liveWord1 : LiveData<String>
//        get() = _mutableWord1
//
//    private var _mutableWord2 = MutableLiveData<String>()
//    val liveWord2 : LiveData<String>
//        get() = _mutableWord2
//
//    private var _mutableWordList = MutableLiveData<List<Post>>()
//    val liveWordList : LiveData<List<Post>>
//        get() = _mutableWordList
//
//
//    fun getPost1() = viewModelScope.launch {
//
//        val post = retrofitInstance.getPost1()
//        Log.d("MainViewModel", post.toString())
//        _mutableWord1.value = post.title
//
//    }
//
//    fun getPostNumber(number : Int) = viewModelScope.launch {
//        val post = retrofitInstance.getPostNumber(number)
//        Log.d("MainViewModel", post.toString())
//        _mutableWord2.value = post.title
//    }
//
//
//    //여기서 받은 데이터 라이브데이터에 집어넣어야함
//    fun getPostAll() = viewModelScope.launch {
//        val postAll = retrofitInstance.getPostAll()
//        Log.d("MainViewModel", postAll.toString())
//        _mutableWordList.value = postAll
//    }
//
//
//}

//28강

class MainViewModel : ViewModel() {

    //val retrofitInstance : MyApi = RetrofitInstance.getInstance().create(MyApi::class.java)

    private val repository = Repository()


    private val _result = MutableLiveData<List<Plant>>()
    val result : LiveData<List<Plant>>
        get() = _result



    fun getAllData() = viewModelScope.launch {
        Log.d("MainViewModel", repository.getAllData().toString())
        _result.value = repository.getAllData()
    }

}
