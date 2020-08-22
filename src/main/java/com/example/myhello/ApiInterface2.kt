package com.example.myhello

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface2 {
    @POST("LogIn")
    fun LogInStudent(@Body requestBody: RequestBody): Call<LogInResponse>
}