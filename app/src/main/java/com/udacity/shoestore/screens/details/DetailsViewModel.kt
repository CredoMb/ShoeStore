package com.udacity.shoestore.screens.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class DetailsViewModel(aShoe: Shoe,pos: Int): ViewModel() {

    private val _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe>
        get() = _shoe

    private val _position = MutableLiveData<Int>()
    val position: LiveData<Int>
        get() = _position

    init {
        _shoe.value = aShoe
        _position.value = pos
    }


}