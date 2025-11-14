package com.example.a2025_android_study

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter : ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(CategoryDiffCallback()) {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val categoryImage: ImageView = itemView.findViewById(R.id.iv_category_image)
        private val categoryName: TextView = itemView.findViewById(R.id.tv_category_name)
        private val cardView: CardView = itemView.findViewById(R.id.category_card_view)

        fun bind(category: Category) {
            categoryImage.setImageResource(category.imageResId)
            categoryName.text = category.name

            // 카드 배경색을 데이터에 따라 동적으로 변경
            val color = ContextCompat.getColor(itemView.context, category.backgroundColorResId)
            cardView.setCardBackgroundColor(color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CategoryDiffCallback : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}