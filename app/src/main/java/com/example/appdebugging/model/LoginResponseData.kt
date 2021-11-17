package com.example.appdebugging.model

import com.google.gson.annotations.SerializedName

data class LoginResponseData(
    @SerializedName("data")
    val data: LoginResponse? = null
)