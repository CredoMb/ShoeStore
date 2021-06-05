package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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


        viewModelFactory = LoginViewModelFactory(!(binding.editPassword.text!!.isEmpty()) &&
                !(binding.editUsername.text!!.isEmpty()))

        viewModel = ViewModelProvider(this, viewModelFactory)
                .get(LoginViewModel::class.java)

        binding.loginButton.setOnClickListener {
            if(viewModel.dataIsEntered.value!!){
                findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
            }
            else {
                Toast.makeText(this.context, "Enter a username and password", Toast.LENGTH_LONG).show()
            }
        }

        // include a constraint layout inside a linear layout
        return binding.root
    }


    //Remove the menu from the
    //login fragment
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }
}