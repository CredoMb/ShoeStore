package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(isDataEntered:Boolean) : ViewModel(){

    // This will help know if the user
    // typed the login and password data
    // set(value) {() -> _dataIsEntered.value = value}
    private val _dataIsEntered = MutableLiveData<Boolean>()

    val dataIsEntered: LiveData<Boolean>
        get() = _dataIsEntered

    private val _warningMessage = MutableLiveData<String>()
    val warningMessage: LiveData<String>
        get() = _warningMessage

    // if the editText are empty
    init{
        _dataIsEntered.value = isDataEntered
        // listener on both buttons
        _warningMessage.value ="Enter a username and password"
    }

    //
    fun setDataIsEntered(b:Boolean){
        _dataIsEntered.value = true
    }

    // Make sure the things (uname and pword) are not empty
    fun onDataIsEnteredComplete(){
        _dataIsEntered.value = false
    }
}