package com.udacity.shoestore.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.models.Shoe

class DetailsViewModelFactory(private val aShoe: Shoe,private val pos: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            return DetailsViewModel(aShoe,pos) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}