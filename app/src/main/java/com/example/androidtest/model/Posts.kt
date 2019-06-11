package com.example.androidtest.model

import com.google.gson.annotations.SerializedName


data class Posts (

	@SerializedName("id") val id : Long,
	@SerializedName("user_name") val user_name : String,
	@SerializedName("user_id") val user_id : String,
	@SerializedName("user_pic") val user_pic : String,
	@SerializedName("message") val message : String,
	@SerializedName("photo") val photo : String,
	@SerializedName("date") val date : String

)