package com.example.a2025_android_study.repository

import com.example.a2025_android_study.api.MyApi
import com.example.a2025_android_study.api.RetrofitInstance

class Repository {

    private val client = RetrofitInstance.getInstance().create(MyApi::class.java)

    suspend fun getAllData() = client.getAllPlants()

}