package com.example.a2025_android_study.retrofit

import com.example.a2025_android_study.data.Plant
import com.example.a2025_android_study.data.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface MyApi {

//    @GET("posts/1")
//    fun getPost1() : Call<Post>
//
//    @GET("posts/{number}")
//    fun getPostNumber(
//        @Path("number") number : Int
//    ) : Call<Post>
    @GET("posts/1")
    suspend fun getPost1() : Post

    @GET("posts/{number}")
    suspend fun getPostNumber(
        @Path("number") number : Int
    ) : Post

    @GET("posts")
    suspend fun getPostAll() : List<Post>

    @GET("googlecodelabs/kotlin-coroutines/master/advanced-coroutines-codelab/sunflower/src/main/assets/plants.json")
    suspend fun getAllPlants() : List<Plant>
}