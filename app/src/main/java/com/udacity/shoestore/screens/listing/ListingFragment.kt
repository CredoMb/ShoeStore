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
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ListingFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.ListAndDetailViewModel

class ListingFragment : Fragment() {

    private lateinit var posTextview: TextView
    private lateinit var mainTextView: TextView
    private lateinit var sizeTextView: TextView
    private lateinit var itemMainLayout: LinearLayout


    private val sharedViewM : ListAndDetailViewModel by activityViewModels()

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

        // Create the textview for all the info
        // to display on the screen
        mainTextView = initTextview(this.context);
        posTextview = initTextview(this.context);
        sizeTextView = initTextview(this.context);

        // The shoeList observe the
        // activity and updates itself accordingly ?
        sharedViewM.shoeList.observe(viewLifecycleOwner, Observer { newList ->
            var i = 0
            if(newList.size > 0) {
                    // Make the place holder
                    // Invisible


                for(shoe in newList) {

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
                        )
                    }

                    mainTextView = initTextview(this.context)
                    posTextview = initTextview(this.context)
                    sizeTextView = initTextview(this.context);

                    // The thing can be empty indeed
                    mainTextView.setText(shoe!!.name)
                    posTextview.setText(i.toString())
                    sizeTextView.setText("| "+shoe!!.size.toString())

                    // Make the position textview invisible
                    // and set its id.
                    posTextview.visibility = View.GONE
                    posTextview.id = R.id.position_text

                    itemMainLayout.addView(mainTextView)
                    itemMainLayout.addView(sizeTextView)
                    itemMainLayout.addView(posTextview)

                    // Add a click listener here

                    binding.listingGroupview.addView(itemMainLayout)

                    // Increment the variable that will
                    // help us to determine the position of
                    // an element inside the list
                    i++
                }
            }else {
                // Make the place holder visible
            }
        })

        binding.addNewButton.setOnClickListener {
            // Send a shoe with no position data !
            findNavController().navigate(ListingFragmentDirections.actionListingToDetails())
        }
        return binding.root

    }

    fun initLinearLayout(context: Context?): LinearLayout{
        var linearLayout = LinearLayout(context);

        linearLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)

        linearLayout.orientation = LinearLayout.VERTICAL
        // android.R.attr.textViewStyle

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
        // Create the main linear layout
        var mainLayout =  LinearLayout(context)

        // var mainLayoutParams: ViewGroup.LayoutParams
        // var mainLayoutParamss = ViewGroup.LayoutParams()
        // Inflate the linear layout
        mainLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)



        // ViewGroup.MarginLayoutParams
        mainLayout.setPadding(8)

        mainTextView = TextView(context);
        mainTextView.text = "Zimbabwe"
        //mainTextView
        //
        // width = wrap content
        //
        mainTextView.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT)

        return true
    }
}