package com.example.kotlin_sample.ui.home

import com.google.gson.annotations.SerializedName

data class UserInfo(@SerializedName("firstName") val firstname: String?,
                    @SerializedName("lastName") val lastname: String?)
