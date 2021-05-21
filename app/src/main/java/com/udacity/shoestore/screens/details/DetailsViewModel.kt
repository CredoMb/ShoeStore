package com.udacity.shoestore.screens.details

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

    init {

        if(aShoe == null)
            _shoe.value = Shoe("",0.0,"","")
        _shoe.value = aShoe
        _position.value = pos
    }

    //
    fun setName(shoeName:String){

        var shoeInter = _shoe.value
        shoeInter?.name = shoeName

        _shoe.value  = shoeInter
    }

    // var name: String, var size: Double, var company: String, var description: String,
    // val images: List<String> = mutableListOf()
    fun setSize(shoeSize:Double){
        var shoeInter = _shoe.value
        shoeInter?.size = shoeSize

        _shoe.value  = shoeInter
    }

    fun setCompany(shoeCie: String) {

        var shoeInter = _shoe.value
        shoeInter?.company = shoeCie

        _shoe.value  = shoeInter
    }

    fun setDescription(shoeDesc:String) {
        var shoeInter = _shoe.value
        shoeInter?.description = shoeDesc

        _shoe.value  = shoeInter
    }
    //
    // fun
}