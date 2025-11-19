package com.example.a2025_android_study

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProduct: ImageView = itemView.findViewById(R.id.iv_product)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_product_title)
        val tvSub: TextView = itemView.findViewById(R.id.tv_product_sub)
        val tvPrice: TextView = itemView.findViewById(R.id.tv_price)
        val btnAdd: ImageButton = itemView.findViewById(R.id.btn_add)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product_horizontal, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]

        holder.ivProduct.setImageResource(product.imageRes)
        holder.tvTitle.text = product.title
        holder.tvSub.text = product.subTitle
        holder.tvPrice.text = product.price

        // 추가 버튼 클릭 이벤트
        holder.btnAdd.setOnClickListener {
            // 나중에 추가
        }
    }

    override fun getItemCount(): Int = products.size
}