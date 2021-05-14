package com.udacity.shoestore.screens.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ListingFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.details.DetailsFragmentArgs
import com.udacity.shoestore.screens.details.DetailsViewModel

class ListingFragment : Fragment() {

    private lateinit var viewModel: ListingViewModel
    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : ListingFragmentBinding =  DataBindingUtil.inflate(
            inflater,
            R.layout.listing_fragment,
            container,
            false
        )

        // I need to get the intent from "details"
        // what if...
        val listingFragmentArgs by navArgs<ListingFragmentArgs>()

        // initiate the view model,
        // now
        viewModel = ViewModelProvider(this).get(ListingViewModel::class.java)

        // What if the
        // thing already exist ?
        viewModel.addShoe(listingFragmentArgs.shoe)
        // I need to add the new thing in the

        textView = TextView(this.context);
        textView.text = "Zimbabwe"

        textView.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
        // listing_groupview
        binding.listingGroupview.addView(textView)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { newList ->
            // We need to update the screen by adding a
            // new element or all of them.

            //for(aShoe in newList) {
                // Create a new layout
                /*val shoeB = DataBindingUtil.inflate(
                        inflater,
                        R.layout.list_item,
                        container,
                        false
                )*/
                /*textView = TextView(this.context);

                textView.layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT)
                //listing_groupview
                binding.listingGroupview*/
            //}
            //
        })

        // viewModel
        // Should I observe anything here ?
        // Let do this !!

        /** Continue here : Receive the new data from the details activity !! */

        // We can create a new Shoe with no value.
        // But how ?
        binding.addNewButton.setOnClickListener {
            // Send a shoe with no data !

            // Send its position, if inferior to 0, then
            // its a new stuff

            // even better
         // findNavController().navigate(ListingFragmentDirections.actionListingToDetails(Shoe("kama", 0.0, "", "")))
            // Shoe("kama", 0.0, "", "")
            findNavController().navigate(ListingFragmentDirections.actionListingToDetails())
        // Let extract
            //
        }

        // Add this to "listing" destination
        //

        /*<argument
            android:name="score"
            android:defaultValue="0"
            app:argType="integer" />*/

        return binding.root

    }

    fun fillTheScreen (listOfShoe:MutableList<Shoe>) {

        // We need to add the thing
        //
    }
}