package com.example.a2025_android_study.api


//import com.example.a2025_android_study.model.Post
import com.example.a2025_android_study.model.Plant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MyApi {

    @GET("googlecodelabs/kotlin-coroutines/master/advanced-coroutines-codelab/sunflower/src/main/assets/plants.json")
    suspend fun getAllPlants() : List<Plant>

}


//7//interface MyApi {
//
//    @GET("posts/1")
//    suspend fun getPost1() : Post
//
//    @GET("posts/{number}")
//    suspend fun getPostNumber(
//        @Path("number") number : Int
//    ) : Post
//
//    @GET("posts")
//    suspend fun getPostAll() : List<Post>
//
//}

//4//6//interface MyApi {
//
//    @GET("posts/1")
//    fun getPost1() : Call<Post>
//
//    @GET("posts/{number}")
//    fun getPostNumber(
//        @Path("number") number : Int
//    ) : Call<Post>
//
//}
