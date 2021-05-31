package com.udacity.shoestore

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private var isLoggedIn = false
    /*
    open fun addView(
    child: View!,
    width: Int,
    height: Int
): Unit*/
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        // Assume that the user is not
        // loggedIn already. The youth is in the
        isLoggedIn = false

        // Store the nav contro
        navController = findNavController(R.id.nav_host_fragment)

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


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logoutMenuButton -> {

                // Remove all the fragment
                // from the backstack
                while (navController.popBackStack()){}

                //Go to the login page
                navController.navigate(R.id.login_destination)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
