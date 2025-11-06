package com.example.a2025_android_study.api

import com.example.a2025_android_study.model.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface MyApi {

    @GET("posts/1")
    suspend fun getPost1() : Post

    @GET("posts/{number}")
    suspend fun getPostNumber(
        @Path("number") number : Int
    ) : Post

    @GET("posts")
    suspend fun getPostAll() : List<Post>

//    @GET("posts/1")
//    suspend fun getPost1() : Post
//
//    @GET("posts/{number}")
//    suspend fun getPostNumber(
//        @Path("number") number : Int
//    ) : Post

//    @GET("posts/1")
//    fun getPost1() : Call<Post>
//
//    @GET("posts/{number}")
//    fun getPostNumber(
//        @Path("number") number : Int
//    ) : Call<Post>
}