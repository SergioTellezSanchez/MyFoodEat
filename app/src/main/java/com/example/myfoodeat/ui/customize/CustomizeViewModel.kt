package com.example.myfoodeat.ui.customize

import androidx.lifecycle.ViewModel
import com.example.myfoodeat.model.IngredientsModel
import com.example.myfoodeat.model.ItemDetails
import com.example.myfoodeat.singleton.OrderSingleton

class CustomizeViewModel : ViewModel() {
    val itemSelected: ItemDetails? = OrderSingleton.itemSelected.value
    val ingredients: ArrayList<IngredientsModel>? = itemSelected?.ingredients
}