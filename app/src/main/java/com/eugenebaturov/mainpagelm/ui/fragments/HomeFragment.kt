package com.eugenebaturov.mainpagelm.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.eugenebaturov.mainpagelm.R
import com.eugenebaturov.mainpagelm.entities.Catalog
import com.eugenebaturov.mainpagelm.entities.Item
import com.eugenebaturov.mainpagelm.ui.fragments.adapters.CatalogAdapter
import com.eugenebaturov.mainpagelm.ui.fragments.adapters.ItemsAdapter

class HomeFragment : Fragment() {

    private lateinit var searchView: SearchView
    private lateinit var rvCatalog: RecyclerView
    private lateinit var rvLimitedItems: RecyclerView
    private lateinit var rvBestPriceItems: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        initializeViewsById(view)
        setAdapters()

        return view
    }

    private fun initializeViewsById(view: View) {

        searchView = view.findViewById(R.id.searchView)
        rvCatalog = view.findViewById(R.id.rv_catalog)
        rvLimitedItems = view.findViewById(R.id.rv_limited_items)
        rvBestPriceItems = view.findViewById(R.id.rv_best_price_items)
    }

    private fun setAdapters() {

        val catalogMenu = Catalog("Каталог", R.drawable.ic_catalog)
        val catalogGarden = Catalog("Сад", R.drawable.tree)
        val catalogLight = Catalog("Освещение", R.drawable.light)
        val catalogTools = Catalog("Инструменты", R.drawable.instruments)
        val catalogMaterials = Catalog("Строительные материалы", R.drawable.materials)
        val catalogDecor = Catalog("Декор", R.drawable.decor)
        val catalogMore = Catalog("Смотреть всё", R.drawable.ic_more)

        val catalogs: List<Catalog> = listOf(
            catalogMenu,
            catalogGarden,
            catalogLight,
            catalogTools,
            catalogMaterials,
            catalogDecor,
            catalogMore
        )

        val item1 = Item("Продукт 1", 250.0, R.drawable.product_example)
        val item2 = Item("Продукт 2", 50.0, R.drawable.product_example)
        val item3 = Item("Продукт 3", 130.0, R.drawable.product_example)
        val item4 = Item("Продукт 4", 540.0, R.drawable.product_example)
        val item5 = Item("Продукт 5", 20.0, R.drawable.product_example)
        val item6 = Item("Продукт 6", 2250.0, R.drawable.product_example)
        val item7 = Item("Продукт 7", 2530.0, R.drawable.product_example)

        val limitedItems: List<Item> = listOf(
            item1, item2, item3, item4, item5, item6, item7
        )

        val bestPriceItems: List<Item> = listOf(item1, item2, item3, item4, item5, item6, item7)

        val adapterCatalog = CatalogAdapter(catalogs, requireContext())
        val adapterLimitedItems = ItemsAdapter(limitedItems, requireContext())
        val adapterBestPriceItems = ItemsAdapter(bestPriceItems, requireContext())

        rvCatalog.adapter = adapterCatalog
        rvLimitedItems.adapter = adapterLimitedItems
        rvBestPriceItems.adapter = adapterBestPriceItems
    }
}