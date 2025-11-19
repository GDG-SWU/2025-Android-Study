package com.example.a2025_android_study

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivCat: ImageView = itemView.findViewById(R.id.iv_cat)
        val tvCatName: TextView = itemView.findViewById(R.id.tv_cat_name)
        val container: LinearLayout = itemView.findViewById(R.id.category_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.ivCat.setImageResource(category.imageRes)
        holder.tvCatName.text = category.name

        // 배경 색상 적용
        category.backgroundRes?.let { colorInt ->
            holder.container.setBackgroundColor(colorInt)
        }
    }

    override fun getItemCount(): Int = categories.size
}