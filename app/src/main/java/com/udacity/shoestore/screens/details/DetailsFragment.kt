package com.udacity.shoestore.screens.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
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
        // We
        viewModelFactory = DetailsViewModelFactory(detailsFragmentArgs.shoe)
        viewModel = ViewModelProvider(this, viewModelFactory)
                .get(DetailsViewModel::class.java)

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

                // Get all the fields
                // Create a new shoes and add it to the
                // list



                // 1) Create the layout

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