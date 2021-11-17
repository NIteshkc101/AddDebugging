package com.example.appdebugging

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.appdebugging.model.LoginBody
import com.example.appdebugging.model.LoginResponseData
import com.example.appdebugging.network.RetroClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var loginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton = findViewById(R.id.button)

        loginButton.setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        if (view == loginButton){

            Log.i("login","login button clicked")

            val loginBody = LoginBody("janakphuyal12+26@gmail.com", "janak123")

            //retrofit call for the user in
            RetroClient.getApiService().loginUser(loginBody)
                .enqueue(object : Callback<LoginResponseData>{
                    override fun onResponse(
                        call: Call<LoginResponseData>,
                        response: Response<LoginResponseData>
                    ) {
                        val result = response.body()?.data
                        Log.i("login","login response receiced ${response.message()}")
                        Log.i("login","login response receiced ${response.code()}")
                        Log.i("login","login response receiced ${response.body()?.data}")

                        if (response.isSuccessful && response.code() == 200) {
                            val accessToken = response.body()?.data?.accessToken
                            val refreshToken = response.body()?.data?.refreshToken
                            val expiresIn = response.body()?.data?.expiresIn
                            val tokenType = response.body()?.data?.tokenType


                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            intent.putExtra("accessToken", accessToken)
                            intent.putExtra("refreshToken", refreshToken)
                            intent.putExtra("expiresIn", expiresIn)
                            intent.putExtra("tokenType", tokenType)
                            startActivity(intent)
                        }
                    }

                    override fun onFailure(call: Call<LoginResponseData>, t: Throwable) {
                        Toast.makeText(this@LoginActivity, "Login Failed", Toast.LENGTH_SHORT).show()

                    }

                })
        }
    }

}