package com.example.appdebugging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var accessTokenTv : TextView
    private lateinit var refreshTokenTv : TextView
    private lateinit var expiresInTv : TextView
    private lateinit var tokenTypeTv : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        accessTokenTv=findViewById(R.id.accessTextViewResult)
        refreshTokenTv=findViewById(R.id.refreshTextViewResult)
        expiresInTv = findViewById(R.id.expiresTextViewResult)
        tokenTypeTv = findViewById(R.id.tokenTypeTextViewResult)



        val accessToken = intent.getStringExtra("accessToken")
        val refreshToken = intent.getStringExtra("refreshToken")
        val expiresIn = intent.getIntExtra("expiresIn",0)
        val tokenType = intent.getStringExtra("tokenType")


        accessTokenTv.text= accessToken
        refreshTokenTv.text= refreshToken
        expiresInTv.text= expiresIn.toString()
        tokenTypeTv.text= tokenType
    }
}