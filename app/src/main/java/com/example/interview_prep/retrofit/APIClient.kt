package com.example.interview_prep.retrofit

import com.google.gson.Gson
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory


class APIClient {
    lateinit var retrofit: Retrofit
    fun getClient():Retrofit{
        retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create(Gson())).build();
        return retrofit;
    }
}