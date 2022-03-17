package com.example.interview_prep.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface APiInterface {
    @GET("/photos")
    fun getData(): Call<List<ResponseData?>?>?
}