package com.example.myfoodeat.singleton

import androidx.lifecycle.MutableLiveData
import com.example.myfoodeat.model.IngredientsModel

object OrderSingleton {

    val ingredients = MutableLiveData<ArrayList<IngredientsModel>>()

    fun setIngredients(foodIngredients: ArrayList<IngredientsModel>) {
        ingredients.value = foodIngredients
    }

//    // 1.
//    var items: List<OrderDetails> = emptyList()
//        private set
//
//    // 2.
//    fun addItem(menuItem: OrderDetails) {
//        items = items + listOf(menuItem)
//    }
//
//    // 3.
//    fun clear() {
//        items = emptyList()
//    }
}