

package com.example.a2025_android_study

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExclusiveOfferAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<ExclusiveOfferAdapter.ProductViewHolder>() {
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.text_product_name)
        val unit: TextView = itemView.findViewById(R.id.text_product_unit)
        val price: TextView = itemView.findViewById(R.id.text_price)
        val image: ImageView = itemView.findViewById(R.id.img_product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product_card, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]

        holder.name.text = product.name
        holder.unit.text = product.unit
        holder.price.text = "$${product.price}"


        holder.image.setImageResource(product.imageResId)
    }


    override fun getItemCount(): Int = products.size
}