package com.example.lessonplan.repository

import com.example.lessonplan.api.RetrofitInstance
import com.example.lessonplan.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post> {
        return  RetrofitInstance.api.getPost2(number)
    }

    suspend fun getGivenPosts(userId: Int, options: Map<String, String>): Response<List<Post>> {
        return RetrofitInstance.api.getGivenPosts(userId, options)
    }

    suspend fun getAllPosts(): Response<List<Post>> {
        return RetrofitInstance.api.getAllPosts()
    }
}