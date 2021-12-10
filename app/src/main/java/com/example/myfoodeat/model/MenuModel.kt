package com.example.myfoodeat.model

import com.google.gson.annotations.SerializedName

data class MenuModel(
    @SerializedName("menu")
    val menu: MenuDetails )

data class MenuDetails(
    @SerializedName("food")
    val food: ArrayList<FoodDetails> = ArrayList(),

    @SerializedName("drinks")
    val drinks: ArrayList<DrinksDetails> = ArrayList(),
)

class FoodDetails (
    name: String,
    description: String,
    price: Double,
    @SerializedName("cooking_time")
    val cooking_time: Int,
    @SerializedName("sauce")
    val sauce: ArrayList<String>,
): MenuItem(name, description, price)

class DrinksDetails(
    name: String,
    description: String,
    price: Double,
): MenuItem(name, description, price)

open class MenuItem  (
    val name: String,
    val description: String,
    val price: Double,
)