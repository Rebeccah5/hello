package com.example.myhello

import com.google.gson.annotations.SerializedName

data class Student2 (
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String
)
