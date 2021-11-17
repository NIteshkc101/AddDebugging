package com.example.appdebugging.network

import com.example.appdebugging.model.LoginBody
import com.example.appdebugging.model.LoginResponse
import com.example.appdebugging.model.LoginResponseData
import com.example.appdebugging.utils.Constants

import retrofit2.Call
import retrofit2.http.*

interface Api  {



    @POST(Constants.loginUrl)
    fun loginUser(
        @Body body: LoginBody
    ):Call<LoginResponseData>


}