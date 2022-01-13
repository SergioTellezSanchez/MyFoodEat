package com.example.myfoodeat.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodeat.BuildConfig
import com.example.myfoodeat.R
import com.example.myfoodeat.model.ItemDetails

class ItemAdapter(
    private val context: Fragment,
    private val resources: Resources,
    private val itemDetails: List<ItemDetails>,
    private val onItemClicked: (position: Int) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View, private val onItemClicked: (position: Int) -> Unit) :
        RecyclerView.ViewHolder(view), View.OnClickListener {
        val textDescription: TextView = view.findViewById(R.id.item_description)
        val textPrice: TextView = view.findViewById(R.id.text_price)
        val productImage: ImageView = view.findViewById(R.id.product_image)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            onItemClicked(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout, onItemClicked)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemDetails[position]
        holder.textDescription.text = item.description
        holder.textPrice.text = context.getString(R.string.dollar_sign, item.price.toString())
        val identifier =
            resources.getIdentifier(item.id, "drawable", BuildConfig.APPLICATION_ID)
        holder.productImage.setImageResource(identifier)
    }

    override fun getItemCount(): Int = itemDetails.size
}