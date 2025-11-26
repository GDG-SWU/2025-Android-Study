package com.example.a2025_android_study

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter : ListAdapter<Product, ProductAdapter.ProductViewHolder>(ProductDiffCallback()) {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImage: ImageView = itemView.findViewById(R.id.iv_product_image)
        private val productName: TextView = itemView.findViewById(R.id.tv_product_name)
        private val productDescription: TextView = itemView.findViewById(R.id.tv_product_description)
        private val productPrice: TextView = itemView.findViewById(R.id.tv_product_price)
        private val addButton: ImageButton = itemView.findViewById(R.id.btn_add)

        fun bind(product: Product) {
            productImage.setImageResource(product.imageResId)
            productName.text = product.name
            productDescription.text = product.description
            productPrice.text = product.price

            addButton.setOnClickListener {
                // 1. CartManager에 1개 추가 (화면 이동 없음)
                CartManager.addProduct(product, 1)

            }

            itemView.setOnClickListener {
                val context = itemView.context
                val intent = android.content.Intent(context, ProductDetailActivity::class.java).apply {
                    putExtra("imageResId", product.imageResId)
                    putExtra("name", product.name)
                    putExtra("description", product.description)
                    putExtra("price", product.price)
                }
                context.startActivity(intent)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}