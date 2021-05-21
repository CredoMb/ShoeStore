package com.udacity.shoestore.screens.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.DetailsFragmentBinding
import com.udacity.shoestore.models.Shoe


/**
 * A simple [Fragment] subclass.
 * Use the [DetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailsFragment : Fragment() {

    private lateinit var viewModel: DetailsViewModel
    private lateinit var viewModelFactory: DetailsViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //
        val binding : DetailsFragmentBinding =  DataBindingUtil.inflate(
            inflater,
            R.layout.details_fragment,
            container,
            false
        )

        val detailsFragmentArgs by navArgs<DetailsFragmentArgs>()
        // What to do now ?
        // We detailsFragmentArgs
        // require "integer"
        // found "int"

        viewModelFactory = DetailsViewModelFactory(detailsFragmentArgs.shoe!!,detailsFragmentArgs.position)
        viewModel = ViewModelProvider(this, viewModelFactory)
                .get(DetailsViewModel::class.java)

        //Log.i("DetailActivity","é pozition yango "+detailsFragmentArgs.position.toString())

        // If the shoe is empty name, cie, size and description
        binding.editShoeName.setText(viewModel.shoe.value?.name)
        binding.editShoeSize.setText(viewModel.shoe.value?.size.toString())
        binding.editCompanyName.setText(viewModel.shoe.value?.company)
        binding.editShoeDescription.setText(viewModel.shoe.value?.description)

        // Take the shoe
        binding.saveButton.setOnClickListener {

            if (!(binding.editShoeName.text!!.isEmpty()) &&
                    !(binding.editShoeSize.text!!.isEmpty())
               ){

                   var cieName = ""
                   var descript = ""

                if(!binding.editCompanyName.text.toString().isEmpty()){
                    cieName = binding.editCompanyName.text.toString()
                }

                if(!binding.editShoeDescription.text.toString().isEmpty()){
                    descript = binding.editShoeDescription.text.toString()
                }

                // Get all the fields
                // Create a new shoes and add it to the
                // list
                Shoe(binding.editShoeName.text!!.toString(),
                    binding.editShoeSize.text!!.toString().toDouble(),
                    cieName,descript)

                // 1) Create the layout

                // send it back with the position
                // we got if it was a new thing, set the
                // position to it default value
                findNavController().navigate(DetailsFragmentDirections.actionDetailsDestinationToListingDestination()
                    .setPosition(viewModel.position.value!!)
                    .setShoe(Shoe(binding.editShoeName.text!!.toString(),
                        binding.editShoeSize.text!!.toString().toDouble(),
                        cieName,descript)))

                // 2) Add it to the listing fragment
                // Size x
                // By add
            } else {

            }

        }
        // Receive the thing and put it inside
        // of the
        return binding.root
    }

    fun fillTheForm() {

    }
}