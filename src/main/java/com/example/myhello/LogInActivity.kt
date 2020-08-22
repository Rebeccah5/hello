package com.example.myhello

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInActivity {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            setContentView(R.layout.LogInActivity)
            btnLogin.setOnClickListener{
                var email=tvEmail.text.toString()
                var password=tvPassword.text.toString()
                Toast.makeText(baseContext,email, Toast.LENGTH_LONG).show()
                Toast.makeText(baseContext,Password, Toast.LENGTH_LONG).show()


                val requestBody = MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("email",email)
                    .addFormDataPart("password",password)
                    .build()

                LogInUser(requestBody)
                Toast.makeText(baseContext, email, Toast.LENGTH_SHORT).show()
            }
        }

        fun LogInUser(requestBody: RequestBody) {
            var apiClient = ApiClient.buildService(ApiInterface::class.java)
            var LogInCall:Call<LogInResponse> =apiClient.LogInStudent(requestBody)
            LogInCall.enqueue(object : Callback<LogInResponse> {
                override fun onFailure(call: Call<LogInResponse>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<LogInResponse>,
                    response: Response<LogInResponse>
                ) {
                    if (response.isSuccessful) {
                        Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                        startActivity(Intent(baseContext, MainActivity::class.java))
                    } else {
                        Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                            .show()
                    }
                }
            })
        }
    }








