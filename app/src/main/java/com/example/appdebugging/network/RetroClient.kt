package com.example.appdebugging.network

import com.example.appdebugging.BuildConfig
import com.example.appdebugging.utils.Constants

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetroClient {

    private var apiService: Api? = null
    private val gsonConverter = GsonConverterFactory.create(GsonBuilder().setLenient().create())

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(gsonConverter)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(getOkHttpClient())
        .build()

    private fun getOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
        return okHttpClient.build()
    }


    fun getApiService(): Api {
        if (apiService == null) {
            apiService = retrofit.create(Api::class.java)
        }
        return apiService ?: retrofit.create(Api::class.java)
    }
}