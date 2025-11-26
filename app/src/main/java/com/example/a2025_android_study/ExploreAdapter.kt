package com.example.a2025_android_study

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

class ExploreAdapter : ListAdapter<ExploreItem, ExploreAdapter.ExploreViewHolder>(ExploreDiffCallback()) {

    class ExploreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cardView: MaterialCardView = itemView.findViewById(R.id.card_view)
        private val imageView: ImageView = itemView.findViewById(R.id.iv_category_image)
        private val nameTextView: TextView = itemView.findViewById(R.id.tv_category_name)

        fun bind(item: ExploreItem) {
            nameTextView.text = item.name
            imageView.setImageResource(item.imageResId)

            try {
                val bgColor = Color.parseColor(item.backgroundColor)
                val strokeColor = Color.parseColor(item.borderColor)

                cardView.setCardBackgroundColor(bgColor) // 배경색 변경
                cardView.strokeColor = strokeColor       // 테두리색 변경
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_explore, parent, false)
        return ExploreViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ExploreDiffCallback : DiffUtil.ItemCallback<ExploreItem>() {
    override fun areItemsTheSame(oldItem: ExploreItem, newItem: ExploreItem): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: ExploreItem, newItem: ExploreItem): Boolean {
        return oldItem == newItem
    }
}