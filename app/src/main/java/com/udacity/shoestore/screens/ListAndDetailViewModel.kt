package com.udacity.shoestore.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ListAndDetailViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe?>>()
    val shoeList: LiveData<MutableList<Shoe?>>
        get() = _shoeList

    init {
        _shoeList.value = mutableListOf<Shoe?>()

    }
    fun addShoe(aShoe: Shoe? ){

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