package com.example.myhello

import android.util.JsonToken
import com.google.gson.annotations.SerializedName

data class LogInResponse(
    @SerializedName("message") var message: String,
    @SerializedName("accessToken") var accessToken:String
)
