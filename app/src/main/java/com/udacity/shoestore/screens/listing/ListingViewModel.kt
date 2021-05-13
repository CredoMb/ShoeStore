package com.udacity.shoestore.screens.listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ListingViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe?>>()
    val shoeList: LiveData<MutableList<Shoe?>>
        get() = _shoeList

    init {
        // We'll create an empty list
        _shoeList.value = mutableListOf<Shoe?>()
    }

    fun addShoe(aShoe:Shoe? ){

        var inter = _shoeList.value
        inter?.add(aShoe)

        _shoeList.value = inter
    }
}