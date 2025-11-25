package com.example.a2025_android_study

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class ProductAdapter (private val productList: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val productImage : ImageView = itemView.findViewById(R.id.product)
        val Name : TextView = itemView.findViewById(R.id.name)
        val Desc : TextView = itemView.findViewById(R.id.description)
        val Price : TextView = itemView.findViewById(R.id.price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.Name.text = product.name
        holder.Desc.text = product.unit
        holder.Price.text = product.price
        holder.productImage.setImageResource(product.imageRes)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}