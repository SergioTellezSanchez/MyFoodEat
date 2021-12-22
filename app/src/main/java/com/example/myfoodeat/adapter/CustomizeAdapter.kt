package com.example.myfoodeat.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodeat.BuildConfig
import com.example.myfoodeat.R
import com.example.myfoodeat.model.IngredientsModel

class CustomizeAdapter(
    private val context: Fragment,
    private val resources: Resources,
    private val ingredients: ArrayList<IngredientsModel>
) : RecyclerView.Adapter<CustomizeAdapter.CustomizeViewHolder>() {

    class CustomizeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textDescription: TextView = view.findViewById(R.id.item_description)
        val textPrice: TextView = view.findViewById(R.id.text_price)
        val productImage: ImageView = view.findViewById(R.id.product_image)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomizeViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.ingredient_item, parent, false)
        return CustomizeViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: CustomizeViewHolder, position: Int) {
        val item = ingredients[position]
        holder.textDescription.text = item.description
        holder.textPrice.text = context.getString(R.string.dollar_sign, item.price.toString())
        val identifier =
            resources.getIdentifier(item.id, "drawable", BuildConfig.APPLICATION_ID)
        holder.productImage.setImageResource(identifier)
    }

    override fun getItemCount(): Int {
       return ingredients.size
    }
}