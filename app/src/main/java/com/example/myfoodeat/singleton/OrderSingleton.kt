package com.example.myfoodeat.singleton

import androidx.lifecycle.MutableLiveData
import com.example.myfoodeat.model.ItemDetails
import com.example.myfoodeat.model.OrderDetails

object OrderSingleton {
    val itemSelected = MutableLiveData<ItemDetails>()
    var itemsInTheOrder: ArrayList<ItemDetails> = ArrayList()
    var order = OrderDetails(
        id = 0,
        items = itemsInTheOrder,
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
            total = calculateTotal(itemsInTheOrder)
        )
    }

    private fun calculateTotal(itemsInTheOrder: ArrayList<ItemDetails>?): Double {
        var total = 0.00
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
