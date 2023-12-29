package com.example.lessonplan.api

import com.example.lessonplan.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SimpleApi {
    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number: Int
    ) : Response<Post>

    @GET("posts")
    suspend fun getGivenPosts(
        @Query("userId") userId: Int,
        @QueryMap options: Map <String, String>
    ) : Response<List<Post>>

    @GET("posts")
    suspend fun getAllPosts(): Response<List<Post>>
}