package com.udacity.shoestore

import android.content.ActivityNotFoundException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.screens.listing.ListingFragmentDirections
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private var isLoggedIn = false
    /*
    open fun addView(
    child: View!,
    width: Int,
    height: Int
): Unit*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        // Assume that the user is not
        // loggedIn already
        isLoggedIn = false

        //
        if(savedInstanceState != null) {
            // go from welcome to "instruction"
            // aka execute the actionWelcomeToInstruction

            // get the loggin State of the user
            // if it's true, remove the first 2
            // destination
        }

    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }


}
