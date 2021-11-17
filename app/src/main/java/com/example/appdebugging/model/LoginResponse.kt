package com.example.appdebugging.model

import com.google.gson.annotations.SerializedName

class LoginResponse {
    @SerializedName("access_token")
    val accessToken: String? = null

    @SerializedName("refresh_token")
    val refreshToken: String? = null

    @SerializedName("token_type")
    val tokenType: String? = null

    @SerializedName("expires_in")
    val expiresIn: Int? = null
}