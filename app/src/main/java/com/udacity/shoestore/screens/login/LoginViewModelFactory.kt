package com.udacity.shoestore.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LoginViewModelFactory(private val isDataEntered:Boolean) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(isDataEntered) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}