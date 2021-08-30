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
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.DetailsFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.ListAndDetailViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [DetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailsFragment : Fragment() {

    private val sharedViewM: ListAndDetailViewModel by activityViewModels()
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val binding: DetailsFragmentBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.details_fragment,
                container,
                false
        )

        val detailsFragmentArgs by navArgs<DetailsFragmentArgs>()

        // Should we observe the shoe
        // such that if there's sum
        // that

        // Display all the shoe data inside of the
        // Detail Fragment
        if (detailsFragmentArgs.position >= 0) {
            val currentShoe = sharedViewM.shoeList.value?.get(detailsFragmentArgs.position)
            binding.shoe = currentShoe

            sharedViewM.setShoe(currentShoe)
        }else {
            binding.shoe = Shoe("",0.0,"","")
        }


        // Attach a listener to the save button
        binding.saveButton.setOnClickListener {

            if (!(binding.editShoeName.text!!.isEmpty()) &&
                    !(binding.editShoeSize.text!!.isEmpty())
            ) {

                    val name : String = binding.shoe!!.name
                    var description: String = binding.shoe!!.description
                var company: String = binding.shoe!!.company
                var size = binding.editShoeSize.text.toString().toDouble()


                if (detailsFragmentArgs.position >= 0) {
                    sharedViewM.updateShoe(detailsFragmentArgs.position, Shoe(name, size, company, description))
                } else {
                    sharedViewM.addShoe(Shoe(name, size, company, description))
                }

                // After updating or adding the shoe
                // navigate back to the Listing Fragment
                findNavController().navigate(
                        DetailsFragmentDirections.actionDetailsDestinationToListingDestination()
                )

            } else {
                Toast.makeText(context, "The Name and Price can not be empty", LENGTH_LONG)
            }
        }
        return binding.root
    }

}