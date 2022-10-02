package com.example.kotlin_sample.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    lateinit var useradded: MutableLiveData<Boolean>
     var isloading =false

    fun login(firstname: String, lastname: String): MutableLiveData<Boolean> {

          useradded = HomeRepository.addUserApiCall(UserInfo(firstname, lastname))


       // useradded.postValue(HomeRepository.addUserApiCall(UserInfo(firstname, lastname)))
        return useradded
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}