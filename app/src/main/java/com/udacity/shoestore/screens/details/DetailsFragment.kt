package com.udacity.shoestore.screens.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
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

        viewModelFactory = DetailsViewModelFactory(detailsFragmentArgs.shoe,detailsFragmentArgs.position)
        viewModel = ViewModelProvider(this, viewModelFactory)
                .get(DetailsViewModel::class.java)

        //Log.i("DetailActivity","é pozition yango "+detailsFragmentArgs.position.toString())

        viewModel.shoe.observe(viewLifecycleOwner, Observer { shoeUpdate ->
            if(shoeUpdate != null){
                binding.editShoeName.setText(shoeUpdate.name)
                binding.editShoeSize.setText(shoeUpdate.size.toString())
                binding.editCompanyName.setText(shoeUpdate.company)
                binding.editShoeDescription.setText(shoeUpdate.description)
            }
        })
        // If the shoe is empty name, cie, size and description

        // Take the shoe
        binding.saveButton.setOnClickListener {

            if (!(binding.editShoeName.text!!.isEmpty()) &&
                    !(binding.editShoeSize.text!!.isEmpty())
               ){

                //

                /* if(!binding.editCompanyName.text.toString().isEmpty()){
                }*/

                    var description:String = binding.editShoeDescription.text.toString()
                    var company:String = binding.editCompanyName.text.toString()
                    var sizeText:String = binding.editShoeSize.text.toString()

                    // The string .toString()
                    // Log.i("Details Fr","PRIX videu "+binding.editShoeSize.text)
                viewModel.setName(""+binding.editShoeName.text)
                viewModel.setDescription(description)
                viewModel.setSize(sizeText)
                viewModel.setCompany(company)


                // 1) Create the layout

                // send it back with the position
                // we got if it was a new thing, set the
                // position to it default value
                findNavController().navigate(
                    DetailsFragmentDirections.actionDetailsDestinationToListingDestination()
                    .setPosition(viewModel.position.value!!)
                    .setShoe(viewModel.shoe?.value)
                )

                // 2) Add it to the listing fragment
            } else {
                Toast.makeText(context,"The Name and Price can not be empty",LENGTH_LONG)
            }
        }
        // Receive the thing and put it inside
        // of the
        return binding.root
    }

    fun fillTheForm() {

    }
}