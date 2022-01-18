package com.example.myfoodeat.model

import com.google.gson.annotations.SerializedName

open class MenuItem(
    val id: String,
    val type: String,
    val description: String,
    val price: Double,
    var selected: Boolean
)

data class MenuModel(
    @SerializedName("menu")
    val menu: ArrayList<ItemDetails> = ArrayList(),
)

class ItemDetails(
    id: String,
    type: String,
    description: String,
    price: Double,
    selected: Boolean,
    @SerializedName("cooking_time")
    val cooking_time: Int,
    @SerializedName("ingredients")
    val ingredients: ArrayList<IngredientsModel>
) : MenuItem(id, type, description, price, selected)

class IngredientsModel(
    id: String,
    type: String,
    description: String,
    price: Double,
    selected: Boolean
) : MenuItem(id, type, description, price, selected)

class OrderDetails(
    var id: Int,
    var items: ArrayList<ItemDetails>,
    var cookingTime: Int,
    var total: Double
)