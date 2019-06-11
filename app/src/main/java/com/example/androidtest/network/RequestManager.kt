package com.example.androidtest.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RequestManager {

        var retrofit : Retrofit? = null
        val BASE_URL : String? = "http://citymani.ezrdv.org/"
        fun getRequestManager(): Retrofit? {
            if (retrofit == null){
                retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit
        }
    }