package com.example.a2025_android_study

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class CartItem (
    val name : String,
    val unit : String,
    val price : String,
    val imageRes : Int,
    var quantity : Int
)

class CartAdapter(private val cartList : ArrayList<CartItem>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>(){
    class CartViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val ivImage : ImageView = view.findViewById(R.id.cart_image)
        val tvName : TextView = view.findViewById(R.id.name)
        val tvUnit : TextView = view.findViewById(R.id.cart_unit)
        val tvPrice : TextView = view.findViewById(R.id.cart_price)
        val tvQuantity : TextView = view.findViewById(R.id.cart_quantity)
        val btnPlus : ImageView = view.findViewById(R.id.cart_plus)
        val btnMinus : ImageView = view.findViewById(R.id.cart_minus)
        val btnDelete : ImageView = view.findViewById(R.id.cart_delete)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = cartList[position]

        holder.tvName.text = item.name
        holder.tvUnit.text = item.unit
        holder.tvPrice.text = item.price
        holder.tvQuantity.text = item.quantity.toString()
        holder.ivImage.setImageResource(item.imageRes)

        holder.btnPlus.setOnClickListener {
            item.quantity++
            holder.tvQuantity.text = item.quantity.toString()
        }
        holder.btnMinus.setOnClickListener {
            if(item.quantity > 1){
                item.quantity--
                holder.tvQuantity.text = item.quantity.toString()
            }
        }
        holder.btnDelete.setOnClickListener {
            cartList.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
            notifyItemRangeChanged(holder.adapterPosition, cartList.size)
        }
    }

    override fun getItemCount(): Int = cartList.size
}