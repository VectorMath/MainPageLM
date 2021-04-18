package com.eugenebaturov.mainpagelm.ui.fragments.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eugenebaturov.mainpagelm.R
import com.eugenebaturov.mainpagelm.entities.Item

class ItemsAdapter(var items: List<Item>, var context: Context) :
    RecyclerView.Adapter<ItemsAdapter.ItemHolder>() {

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var item: Item
        var titleTextView: TextView = itemView.findViewById(R.id.item_title)
        var priceTextView: TextView = itemView.findViewById(R.id.item_price)
        var imageView: ImageView = itemView.findViewById(R.id.item_image)

        fun bind(item: Item) {
            this.item = item

            titleTextView.text = this.item.title
            priceTextView.text = this.item.price.toString()
            imageView.setImageResource(this.item.imageResourceId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.list_item_limited, parent, false)

        return ItemHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
}