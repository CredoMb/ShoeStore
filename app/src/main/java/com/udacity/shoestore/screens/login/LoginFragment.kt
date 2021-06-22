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

            // Here, we should check to see if the data was
            // entered
            if(!(binding.editUsername.text!!.isEmpty())&&!(binding.editPassword.text!!.isEmpty()) ){
                findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
            }
            else {
                Toast.makeText(this.context, "Enter a username and password", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

    //Remove the menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }
}