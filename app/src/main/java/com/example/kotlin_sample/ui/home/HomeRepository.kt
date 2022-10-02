package com.example.kotlin_sample.ui.home;

import androidx.lifecycle.MutableLiveData
import com.example.kotlin_sample.RetrofitClient
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object HomeRepository {
    val userInfo = MutableLiveData<Boolean>()
    var isloading = false

    fun addUserApiCall(userData: UserInfo): MutableLiveData<Boolean> {

        val call = RetrofitClient.apiInterface.addUser(userData)
       userInfo.value = false
       isloading = true

        call.enqueue(object : Callback<Unit> {
          /*  override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", "Failure:" + t.message.toString())
            }

            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                //TODO("Not yet implemented")
                Log.v("DEBUG : ", "Success Response =" + response.body() + "  " + response.code())
            }*/

            override fun onFailure(call: Call<Unit>, t: Throwable) {
               // TODO("Not yet implemented")
                Log.v("DEBUG : ", "Failure:" + t.message.toString())



            }

            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
               // TODO("Not yet implemented")
                Log.v("DEBUG : ", "Success Response =" + response.body() + "  " + response.code())
                if(response.code()==200)
                {
                    userInfo.value = true;
                }
                    //DEBUG:: Success Response =kotlin.Unit  200

            }

        })
        return userInfo
    }
}






