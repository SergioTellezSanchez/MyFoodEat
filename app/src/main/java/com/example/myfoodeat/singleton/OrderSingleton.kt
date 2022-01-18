package com.example.myfoodeat.singleton

import androidx.lifecycle.MutableLiveData
import com.example.myfoodeat.model.ItemDetails
import com.example.myfoodeat.model.OrderDetails

object OrderSingleton {
    val itemSelected = MutableLiveData<ItemDetails>()
    var itemsInTheOrder: ArrayList<ItemDetails> = ArrayList()
    private var total: Double = 0.00
    var cookingTime: Int = 0

    var order = OrderDetails(
        id = 0,
        items = itemsInTheOrder,
        cookingTime = cookingTime,
        total = 0.00
    )

    fun setItemSelected(item: ItemDetails) {
        itemSelected.value = item
    }

    fun addToOrder(item: ItemDetails) {
        itemsInTheOrder = (arrayListOf(item) + itemsInTheOrder) as ArrayList<ItemDetails>
        order = OrderDetails(
            id = 1,
            items = itemsInTheOrder,
            cookingTime = calculateCookingTime(itemsInTheOrder),
            total = calculateTotal(itemsInTheOrder)
        )
    }

    private fun calculateCookingTime(itemsInTheOrder: ArrayList<ItemDetails>?): Int {
        if (itemsInTheOrder != null) {
            val itemsSelected = itemsInTheOrder.filter { item -> item.selected }
            cookingTime = itemsSelected.maxOf {
                it.cooking_time
            }
        }
        return cookingTime
    }

    private fun calculateTotal(itemsInTheOrder: ArrayList<ItemDetails>?): Double {
        if (itemsInTheOrder != null) {
            var i = 0
            val itemsSelected = itemsInTheOrder.filter { item -> item.selected }
            while (i < itemsSelected.size) {
                total += itemsSelected[i].price
                i++
            }
        }
        return total
    }

//    fun clear() {
//        itemsInTheOrder = ArrayList()
//    }
}
