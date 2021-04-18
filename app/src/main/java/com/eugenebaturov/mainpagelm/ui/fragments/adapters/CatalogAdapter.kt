package com.eugenebaturov.mainpagelm.ui.fragments.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eugenebaturov.mainpagelm.R
import com.eugenebaturov.mainpagelm.entities.Catalog

class CatalogAdapter(var catalogs: List<Catalog>, var context: Context) :
    RecyclerView.Adapter<CatalogAdapter.CatalogHolder>() {

    inner class CatalogHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var catalog: Catalog

        private  var titleTextView: TextView = itemView.findViewById(R.id.catalog_title)
        private  var imageView: ImageView = itemView.findViewById(R.id.catalog_img)

        fun bind(catalog: Catalog) {

            this.catalog = catalog

            titleTextView.text = this.catalog.title
            imageView.setImageResource(this.catalog.imageResourceId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogHolder {

        lateinit var view: View

        when (viewType) {
            0 -> {
                view = LayoutInflater
                    .from(context)
                    .inflate(R.layout.item_catalog, parent, false)
            }

            1 -> {
                view = LayoutInflater
                    .from(context)
                    .inflate(R.layout.item_list_catalog, parent, false)
            }

            2 -> {
                view = LayoutInflater
                    .from(context)
                    .inflate(R.layout.item_more, parent, false)
            }
        }

        return CatalogHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        var type = 0
        type = when (position) {
            0 -> 0
            catalogs.size - 1 -> 2
            else -> 1
        }

        return type
    }

    override fun getItemCount(): Int = catalogs.size

    override fun onBindViewHolder(holder: CatalogHolder, position: Int) {
        val catalog = catalogs[position]
        holder.bind(catalog)
    }
}