package com.example.kotlin_sample

import com.example.kotlin_sample.ui.home.UserInfo
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body
import retrofit2.http.GET;
import retrofit2.http.Headers
import retrofit2.http.POST;

interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST("/users/")
    fun addUser(@Body userData: UserInfo): Call<Unit>

}