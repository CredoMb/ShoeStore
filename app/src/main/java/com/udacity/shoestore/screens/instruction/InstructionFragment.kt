package com.udacity.shoestore.screens.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionFragmentBinding
import com.udacity.shoestore.screens.welcome.WelcomeFragmentDirections

class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : InstructionFragmentBinding =  DataBindingUtil.inflate(
            inflater,
            R.layout.instruction_fragment,
            container,
            false
        )

        binding.listingButton.setOnClickListener {
            findNavController().navigate(InstructionFragmentDirections.actionInstructionToListing())
        }
        return binding.root
    }

}