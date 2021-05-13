package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment: Fragment() {

    private var isDataTyped = false

    private lateinit var viewModel: LoginViewModel
    private lateinit var viewModelFactory: LoginViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : LoginFragmentBinding =  DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )


        binding.loginButton.setOnClickListener {
            goToWelcomeOrDisplayToast(!(binding.editPassword.text!!.isEmpty()) &&
                                         !(binding.editUsername.text!!.isEmpty())
                                     )
        }

        binding.signupButton.setOnClickListener {
            goToWelcomeOrDisplayToast(!(binding.editPassword.text!!.isEmpty()) &&
                                         !(binding.editUsername.text!!.isEmpty())
                                     )
        }

        return binding.root
    }

    fun goToWelcomeOrDisplayToast(b:Boolean){
        if(b){
            findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
        }
        else {
            Toast.makeText(this.context,"Enter a username and password",Toast.LENGTH_LONG).show()
        }
    }

    // You need some login informations to continue in this app


    // define the behavior of the login button
    // to first check if the "fields" are not empty
    // then move the process forward
}