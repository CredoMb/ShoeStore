package com.udacity.shoestore.screens.listing

import android.content.Context
import android.os.Bundle
import android.util.Log
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
import androidx.navigation.fragment.findNavController
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

        var sampleList = listOf<String>("gana","kobra","milan")

        // If a new shoes was created inside of the

        if(listingFragmentArgs.position < 0 && listingFragmentArgs.shoe!=null)
            viewModel.addShoe(listingFragmentArgs.shoe)
        else if(listingFragmentArgs.position >= 0 ) {
            viewModel.updateShoe(listingFragmentArgs.position, listingFragmentArgs.shoe)
        }
        // Create one big linear layout
        // and get it
        mainTextView = initTextview(this.context);
        posTextview = initTextview(this.context);

        // The shoeList observe the
        // activity and updates itself accordingly ?
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { newList ->

            var i = 0
            if(newList.size > 0) {
                for(shoe in newList) {
                    // Create a new layout shoe in newList
                    //i in 1..5 sampleList
                    // Log.i("ListingFr","Ba shooze "+shoe?.name)
                   // Log.i("ListingFr","shooze quantity "+newList.size.toString())

                    //.setText("zie")

                    itemMainLayout = initLinearLayout(this.context)
                    // Set a click listener that
                    // makes us go to the detail Fragment
                    itemMainLayout.setOnClickListener {

                        // Get the position of the current element
                        val pos = (it.findViewById<TextView>(R.id.position_text).text).toString()

                        // Send the position to the thing
                        findNavController().navigate(
                                ListingFragmentDirections.actionListingToDetails()
                                .setPosition(pos.toInt())
                                    .setShoe(newList.get(pos.toInt()))
                        )

                        //findNavController().navigate(ListingFragmentDirections.actionListingToDetails())
                    }

                    mainTextView = initTextview(this.context)
                    posTextview = initTextview(this.context)

                    // The thing can be empty indeed
                    mainTextView.setText(shoe!!.name)
                    posTextview.setText(i.toString())

                    // Make the position textview invisible
                    // and set its id.
                    posTextview.visibility = View.GONE
                    posTextview.id = R.id.position_text

                    itemMainLayout.addView(mainTextView)
                    itemMainLayout.addView(posTextview)

                    // Add a click listener here

                    binding.listingGroupview.addView(itemMainLayout)

                    /*textView = TextView(this.context);


                    //listing_groupview
                    binding.listingGroupview*/

                    i++
                }
            }else {
                Log.i("MainActivity","eza videu")
            }

            //
        })

        /** Continue here : Receive the new data from the details activity !! */

        // We can create a new Shoe with no value.
        // But how ?
        binding.addNewButton.setOnClickListener {
            // Send a shoe with no data !
            findNavController().navigate(ListingFragmentDirections.actionListingToDetails())
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