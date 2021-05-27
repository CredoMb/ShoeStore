package com.udacity.shoestore.screens.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class DetailsViewModel(aShoe: Shoe?,pos: Int): ViewModel() {

    private val _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe>
        get() = _shoe

    private val _position = MutableLiveData<Int>()
    val position: LiveData<Int>
        get() = _position

    // As soon
    init {

        if(aShoe == null)
            _shoe.value = Shoe("",0.0,"","")
        else
            _shoe.value = aShoe

        _position.value = pos
    }

    //
    fun setName(shoeName:String){

        //Log.i("Details Fr","lénom "+shoeName)
        _shoe.value  = Shoe(shoeName,_shoe.value!!.size,
            _shoe.value!!.company,_shoe.value!!.description)
    }

    // var name: String, var size: Double, var company: String, var description: String,
    // val images: List<String> = mutableListOf()
    fun setSize(shoeSize:String){
        //
        _shoe.value  = Shoe(_shoe.value!!.name,shoeSize.toDouble(),
            _shoe.value!!.company,_shoe.value!!.description)
    }

    fun setCompany(shoeCie: String) {
        //
        Log.i("Details VM","Cie eza "+shoeCie)

        _shoe.value  = Shoe(_shoe.value!!.name,_shoe.value!!.size,
            shoeCie,_shoe.value!!.description)
    }

    fun setDescription(shoeDesc:String) {
        _shoe.value  = Shoe(_shoe.value!!.name,_shoe.value!!.size,
            _shoe.value!!.company,shoeDesc)
    }

    //
    // fun
}