package com.example.a2025_android_study.repository

import com.example.a2025_android_study.api.MyAPI

class Repository {

    private val client = RetrofitInstance.getInstance().create(MyAPI::class.java)

    suspend fun getAllData() = client.getAllPlants()

}