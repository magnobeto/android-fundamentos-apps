package com.example.retrofitexample

import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    fun list(): Call<List<PostModel>>
}