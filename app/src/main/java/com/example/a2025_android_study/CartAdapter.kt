package com.example.a2025_android_study

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(
    private val cartList: List<CartItem>,
    private val onCartChanged: () -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.iv_cart_image)
        val name: TextView = itemView.findViewById(R.id.tv_cart_name)
        val desc: TextView = itemView.findViewById(R.id.tv_cart_desc)
        val price: TextView = itemView.findViewById(R.id.tv_cart_price)
        val quantity: TextView = itemView.findViewById(R.id.tv_quantity)
        val btnMinus: ImageButton = itemView.findViewById(R.id.btn_minus)
        val btnPlus: ImageButton = itemView.findViewById(R.id.btn_plus)
        val btnRemove: ImageView = itemView.findViewById(R.id.btn_remove)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isNotEmpty()) {
            if (payloads[0] == "UPDATE_QUANTITY") {
                val item = cartList[position]

                // 1. 수량 갱신
                holder.quantity.text = item.quantity.toString()

                // 2. 가격 갱신 (계산 로직)
                val priceString = item.product.price.replace("$", "").trim()
                val unitPrice = priceString.toDoubleOrNull() ?: 0.0
                val totalPrice = unitPrice * item.quantity
                holder.price.text = String.format("$%.2f", totalPrice)

                return // 이미지나 이름은 건드리지 않고 함수 종료
            }
        }
        // 신호가 없으면 그냥 원래대로 전체 갱신 (스크롤할 때 등)
        super.onBindViewHolder(holder, position, payloads)
    }

    // [2] 전체 업데이트 (기존 코드 - 이미지 등 모든 걸 세팅)
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = cartList[position]

        holder.image.setImageResource(item.product.imageResId)
        holder.name.text = item.product.name
        holder.desc.text = item.product.description

        // 가격 초기 세팅
        val priceString = item.product.price.replace("$", "").trim()
        val unitPrice = priceString.toDoubleOrNull() ?: 0.0
        val totalPrice = unitPrice * item.quantity
        holder.price.text = String.format("$%.2f", totalPrice)

        holder.quantity.text = item.quantity.toString()

        // [+] 버튼 클릭
        holder.btnPlus.setOnClickListener {
            CartManager.increaseQuantity(position)
            // ★ 수정됨: "UPDATE_QUANTITY"라는 꼬리표를 붙여서 보냄
            notifyItemChanged(position, "UPDATE_QUANTITY")
            onCartChanged()
        }

        // [-] 버튼 클릭
        holder.btnMinus.setOnClickListener {
            CartManager.decreaseQuantity(position)
            // ★ 수정됨: "UPDATE_QUANTITY"라는 꼬리표를 붙여서 보냄
            notifyItemChanged(position, "UPDATE_QUANTITY")
            onCartChanged()
        }

        // [X] 삭제 버튼 클릭 (삭제는 전체가 사라져야 하므로 그냥 둠)
        holder.btnRemove.setOnClickListener {
            CartManager.removeProduct(position)
            notifyDataSetChanged() // 이건 리스트 구조가 바뀌니 전체 갱신
            onCartChanged()
        }
    }

    override fun getItemCount(): Int = cartList.size
}