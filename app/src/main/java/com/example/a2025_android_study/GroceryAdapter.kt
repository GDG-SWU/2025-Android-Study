package com.example.a2025_android_study

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

data class Grocery (val name : String, val image : Int, val color : String)

class GroceryAdapter(private val list: List<Grocery>) : RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder>() {
    class GroceryViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val ivImage : ImageView = view.findViewById(R.id.iv_grocery)
        val tvName : TextView = view.findViewById(R.id.tv_grocery_name)
        val cardView : CardView = view as CardView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_groceries, parent, false)
        return GroceryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        val item = list[position]

        holder.tvName.text = item.name
        holder.ivImage.setImageResource(item.image)

        holder.cardView.setCardBackgroundColor(Color.parseColor(item.color))
    }

    override fun getItemCount(): Int = list.size
}