package com.udacity.shoestore.screens.listing

import android.content.ActivityNotFoundException
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.core.view.marginStart
import androidx.core.view.setPadding
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
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

        setHasOptionsMenu(true)

        val binding : ListingFragmentBinding =  DataBindingUtil.inflate(
            inflater,
            R.layout.listing_fragment,
            container,
            false
        )

        sharedViewM.shoeList.observe(viewLifecycleOwner, Observer { newList ->
            var i = 0
            if(newList.size > 0) {
                for(shoe in newList) {

                    itemMainLayout = initLinearLayout(this.context)
                    // Set a click listener that
                    // makes us go to the detail Fragment
                    itemMainLayout.setOnClickListener {

                        // Get the position of the current element
                        val pos = (it.findViewById<TextView>(R.id.position_text).text).toString()

                        // Send the position to the next fragment
                        findNavController().navigate(
                                ListingFragmentDirections.actionListingToDetails()
                                .setPosition(pos.toInt())
                        )
                    }

                    mainTextView = initTextview(this.context)
                    posTextview = initTextview(this.context)
                    sizeTextView = initTextview(this.context);

                    mainTextView.setText(shoe!!.name)
                    mainTextView.setTextColor(resources.getColor(R.color.black_text_color));

                    posTextview.setText(i.toString())
                    sizeTextView.setText("| $"+shoe!!.size.toString())

                    // Make the position textview invisible
                    // and set its id.
                    posTextview.visibility = View.GONE
                    posTextview.id = R.id.position_text

                    // Put the three textview into
                    // the same groupview
                    itemMainLayout.addView(mainTextView)
                    itemMainLayout.addView(sizeTextView)
                    itemMainLayout.addView(posTextview)

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

        return binding.root

    }

    fun initLinearLayout(context: Context?): LinearLayout{
        var linearLayout = LinearLayout(context);

        linearLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)

        linearLayout.orientation = LinearLayout.HORIZONTAL

        return linearLayout
    }

    fun initTextview(context: Context?): TextView{

        var textView = TextView(context)

        textView.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)

        return textView
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()

        inflater.inflate(R.menu.listing_menu,menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.addShoeMenuButton -> findNavController().navigate(ListingFragmentDirections.actionListingToDetails())
            R.id.logoutMenuButton -> {
                // Remove all the fragment
                // from the backstack
                while (findNavController().popBackStack()){}

                //Go to the login page
                findNavController().navigate(R.id.login_destination)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}