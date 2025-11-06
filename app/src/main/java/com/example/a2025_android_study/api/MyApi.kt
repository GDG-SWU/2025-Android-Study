package com.example.a2025_android_study.api

import com.example.a2025_android_study.model.Plant
import com.example.a2025_android_study.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

//interface MyApi {
//
//    @GET("posts/1")
//    suspend fun getPost1() : Post
//
//    @GET("posts/{number}")
//    suspend fun getPostNumber(
//        @Path("number") number : Int
//    ) : Post
//
//
//    //28강 추가
//    @GET("posts")
//    suspend fun getPostAll() : List<Post>
//
//}



//29강

interface MyApi {

    @GET("googlecodelabs/kotlin-coroutines/master/advanced-coroutines-codelab/sunflower/src/main/assets/plants.json")
    suspend fun getAllPlants() : List<Plant>

}