package com.udacity.shoestore.screens.listing

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ListingFragmentBinding
import com.udacity.shoestore.models.Shoe

class ListingFragment : Fragment() {

    private lateinit var viewModel: ListingViewModel
    private lateinit var mainTextView: TextView
    private lateinit var itemMainLayout: LinearLayout
    private lateinit var posTextview: TextView

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
        // now.
        viewModel = ViewModelProvider(this).get(ListingViewModel::class.java)

        // Create a list of texts
        var sampleList = listOf<String>("gana","kobra","milan")
        // Inflate the linear layout of the item
       // itemLayout = binding.root.findViewById<LinearLayout>(R.id.list_item_layout);

        // Add the text to the linear layout textview
        // itemLayout.listing_groupview
        // What to do now ?
        //

        // var mainLayoutParams: ViewGroup.LayoutParams
        // var mainLayoutParamss = ViewGroup.LayoutParams()
        // Inflate the linear layout


        // Add them to the text
        // What if the
        // thing already exist ?
        viewModel.addShoe(listingFragmentArgs.shoe)
        // I need to add the new thing in the

        // Create one big linear layout
        // and get it

        mainTextView = initTextview(this.context);
        posTextview = initTextview(this.context);
        // The shoeList observe the
        // activity and updates itself accordingly ?
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { newList ->
            // We need to update the screen by adding a
            // new element or all of them.

            var i = 0

            for(shoe in sampleList) {
                // Create a new layout
                    //i in 1..5
                /*val shoeB = DataBindingUtil.inflate(
                        inflater, aShoe in newList
                        R.layout.list_item,
                        container,
                        false
                )*/
                //.setText("zie")
                itemMainLayout = initLinearLayout(this.context)
                mainTextView = initTextview(this.context)
                posTextview = initTextview(this.context)

                mainTextView.setText(shoe)
                posTextview.setText(i.toString())

                // Make the position textview invisible
                // and set its id.
                posTextview.visibility = View.GONE
                posTextview.id

                itemMainLayout.addView(mainTextView)
                itemMainLayout.addView(posTextview)

                binding.listingGroupview.addView(itemMainLayout)

                /*textView = TextView(this.context);


                //listing_groupview
                binding.listingGroupview*/

                i++
            }
            //
        })

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
            // findNavController().navigate(ListingFragmentDirections.actionListingToDetails())
        // Let extract
            // Keep going bro, just keep going !!
        }

        return binding.root

    }

    fun fillTheScreen (listOfShoe:MutableList<Shoe>) {

        // We need to add the thing
        //
    }

    fun initLinearLayout(context: Context?): LinearLayout{
        var linearLayout = LinearLayout(context);

        linearLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)

        linearLayout.orientation = LinearLayout.VERTICAL

        return linearLayout
    }

    fun initTextview(context: Context?): TextView{

        var textView = TextView(context);
        textView.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)
        return textView
    }
    // Create a LinearLayout with one textView

    fun generateALayout(context: Context): Boolean {
        // Create th emain linear layout
        var mainLayout =  LinearLayout(context)

        // var mainLayoutParams: ViewGroup.LayoutParams
        // var mainLayoutParamss = ViewGroup.LayoutParams()
        // Inflate the linear layout

        mainLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)

        mainLayout.setPadding(8)
        //

        mainTextView = TextView(context);
        mainTextView.text = "Zimbabwe"

        mainTextView.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)

        return true
    }

}