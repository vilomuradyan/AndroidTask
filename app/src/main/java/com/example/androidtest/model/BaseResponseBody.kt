package com.example.androidtest.model

import com.google.gson.annotations.SerializedName

data class BaseResponseBody (

	@SerializedName("total_pages") val total_pages : Int,
	@SerializedName("page") val page : Int,
	@SerializedName("posts") val posts : List<Posts>
)