package com.example.myfoodeat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodeat.R
import com.example.myfoodeat.model.MenuModel
import com.example.myfoodeat.ui.drinks.DrinksFragment
import com.example.myfoodeat.ui.food.FoodFragment

class ItemAdapter(private val context: Fragment, private val menu: MenuModel, private val menuItemType: String): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textDescription: TextView = view.findViewById(R.id.item_description)
        val textPrice: TextView = view.findViewById(R.id.text_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
    val item =
           when (menuItemType) {
                "food" -> menu.menu.food[position]
                "drinks" -> menu.menu.drinks[position]
               else -> null
        }

        if (item != null) {
            holder.textDescription.text = item.description
            holder.textPrice.text = context.getString(R.string.dollar_sign, item.price.toString())
        }

    }

    override fun getItemCount(): Int {
    return when (menuItemType) {
        "food" -> menu.menu.food.size
        "drinks" -> menu.menu.drinks.size
        else -> 0
    }
    }
}