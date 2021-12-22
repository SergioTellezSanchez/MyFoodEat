package com.example.myfoodeat.ui.order

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    private val _id = MutableLiveData<String>()
    val id: LiveData<String> = _id

    private val _quantity = MutableLiveData<Int>()
    val quantity: LiveData<Int> = _quantity

    private val _price = MutableLiveData<Double>()
    val price: LiveData<Double> = _price

    fun setId(itemId: String) {
        _id.value = itemId
    }

    fun setQuantity(numberOfItems: Int) {
        _quantity.value = numberOfItems
    }

    init {
        resetOrder()
    }

    fun resetOrder() {
        _id.value = ""
        _quantity.value = 0
        _price.value = 0.0
    }

}