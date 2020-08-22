package com.example.myhello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_registration)
        tvRegister.setOnClickListener{
            var FirstName=etFirstName.text.toString()
            var LastName=etLastName.text.toString()
            var Email=etEmail.text.toString()
            var PhoneNumber=etPhoneNumber.text.toString()
            var Password=etPassword.text.toString()
            var ConfirmPassword=etConfirmPassword.text.toString()
            Toast.makeText(baseContext,Email,Toast.LENGTH_LONG).show()
            Toast.makeText(baseContext,Password,Toast.LENGTH_LONG).show()
            Toast.makeText(baseContext,ConfirmPassword,Toast.LENGTH_LONG).show()

            val requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("first_name",firstName)
                .addFormDataPart("last_name",lastName)
                .addFormDataPart("email", email)
                .addFormDataPart("phone_number",phoneNumber)
                .addFormDataPart("password",password)
                .build()

            registerUser(requestBody)
            Toast.makeText(baseContext, lastName, Toast.LENGTH_SHORT).show()
        }
    }

    fun registerUser(requestBody: RequestBody) {
        var apiClient = ApiClient.buildService(ApiInterface::class.java)
        var registrationCall = apiClient.registerStudent(requestBody)
        registrationCall.enqueue(object : Callback<RegistrationResponse> {
            override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<RegistrationResponse>,
                response: Response<RegistrationResponse>
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







