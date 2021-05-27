package com.udacity.shoestore.screens.listing

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ListingViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe?>>()
    val shoeList: LiveData<MutableList<Shoe?>>
        get() = _shoeList
    //
    init {
        // We'll create an empty list
        _shoeList.value = mutableListOf<Shoe?>()

    }

    // var sampleList = listOf<String>("gana","kobra","milan")
    //

    fun addShoe(aShoe:Shoe? ){
        /*Shoe("gana",45.0,"fe","good")
            ,Shoe("gano",455.0,"fe","good")
            ,Shoe("gani",445.0,"fe","good")*/

        var inter = _shoeList.value
        inter?.add(aShoe)

        _shoeList.value = inter
    }

    fun updateShoe(pos: Int,aShoe: Shoe? ){

        var inter = _shoeList.value
        inter?.set(pos,aShoe)

        _shoeList.value = inter
    }
}