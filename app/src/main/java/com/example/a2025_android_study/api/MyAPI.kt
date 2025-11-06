package com.example.a2025_android_study.api

import com.example.a2025_android_study.model.Plant
import retrofit2.http.GET
import retrofit2.http.Path

interface MyAPI {

    @GET("googlecodelabs/kotlin-coroutines/master/advanced-coroutines-codelab/sunflower/src/main/assets/plants.json")
    suspend fun getAllPlants() : List<Plant>
}