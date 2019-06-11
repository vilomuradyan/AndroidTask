package com.example.androidtest.network

import com.example.androidtest.model.BaseResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface PostsAPI {

    @GET("main/test")
    fun getPosts() : Call<BaseResponseBody>
}