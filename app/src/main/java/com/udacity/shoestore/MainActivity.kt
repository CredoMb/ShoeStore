package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private var isLoggedIn = false

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

    // Add a logout menu to return to the login screen
    // As long as I'm logged In, never return to those pages

    // Click on logout = return to the login and break the curse
    // Each step should pop off the previous page and we'll end up
    // ...

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    // if we are inside of the "insertFragement"
    // set it to true

    // get the nav host

    // check the current page
    //
}
