package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment: Fragment() {

    private var isDataTyped = false

    private lateinit var viewModel: LoginViewModel
    private lateinit var viewModelFactory: LoginViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true);
    }

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

    fun goToWelcomeOrDisplayToast(b: Boolean){
        if(b){
            findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
        }
        else {
            Toast.makeText(this.context, "Enter a username and password", Toast.LENGTH_LONG).show()
        }
    }

    //Remove the menu from the
    //fragment
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }
}