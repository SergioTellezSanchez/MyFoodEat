package com.example.myfoodeat.model

import com.google.gson.annotations.SerializedName

data class MenuModel(
    @SerializedName("menu")
    val menu: MenuDetails
)

data class MenuDetails(
    @SerializedName("food")
    val food: ArrayList<FoodDetails> = ArrayList(),
    @SerializedName("drinks")
    val drinks: ArrayList<DrinksDetails> = ArrayList(),
)

open class MenuItem  (
    val id: String,
    val description: String,
    val price: Double
)

class FoodDetails (
    id: String,
    description: String,
    price: Double,
    @SerializedName("cooking_time")
    val cooking_time: Int,
    @SerializedName("sauce")
    val sauce: ArrayList<String>,
    @SerializedName("ingredients")
    val ingredients: ArrayList<IngredientsModel>
): MenuItem(id, description, price)

class IngredientsModel(
    id: String,
    description: String,
    price: Double
): MenuItem(id, description, price)

class DrinksDetails(
    id: String,
    description: String,
    price: Double
): MenuItem(id, description, price)


//data class OrderModel(
//    @SerializedName("order")
//    val order: ArrayList<OrderDetails> = ArrayList()
//)
//
//class OrderDetails(
//    id: String,
//    food: ArrayList<FoodDetails>,
//    drinks: ArrayList<DrinksDetails>,
//    quantity: Int,
//    total: Double
//)