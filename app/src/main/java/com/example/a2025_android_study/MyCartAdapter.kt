package com.example.a2025_android_study

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyCartAdapter(private val cartItems: List<CartItem>) :
    RecyclerView.Adapter<MyCartAdapter.CartItemViewHolder>() {

    // ⭐ 뷰 홀더: item_cart_product.xml 내부의 뷰들을 연결하는 역할
    inner class CartItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.text_cart_product_name)
        val unit: TextView = itemView.findViewById(R.id.text_cart_product_unit)
        val price: TextView = itemView.findViewById(R.id.text_cart_item_price)
        val image: ImageView = itemView.findViewById(R.id.img_cart_product)
        val quantity: TextView = itemView.findViewById(R.id.text_cart_quantity)
        val removeButton: ImageButton = itemView.findViewById(R.id.btn_remove_item)

        // ⭐ [수정] 수량 조절 버튼 연결 추가
        val plusButton: ImageButton = itemView.findViewById(R.id.btn_cart_plus)
        val minusButton: ImageButton = itemView.findViewById(R.id.btn_cart_minus)
    }

    // 뷰 홀더 생성: item_cart_product.xml 레이아웃을 사용
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart_product, parent, false)
        return CartItemViewHolder(view)
    }

    // 데이터 바인딩: 데이터를 View에 연결
    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        val cartItem = cartItems[position]

        updateItemTotal(holder, cartItem)

        // ⭐ [추가] 삭제 버튼 클릭 리스너
        holder.removeButton.setOnClickListener {
            CartManager.removeItem(cartItem)

            notifyDataSetChanged()
        }

        holder.plusButton.setOnClickListener {
            cartItem.quantity++ // 수량 증가 (CartItem의 quantity는 var여야 함)
            updateItemTotal(holder, cartItem)
        }

        // ⭐ [추가] 마이너스 버튼 클릭 리스너
        holder.minusButton.setOnClickListener {
            if (cartItem.quantity > 1) { // 최소 수량은 1
                cartItem.quantity--
                updateItemTotal(holder, cartItem)
            }
        }
    }

    override fun getItemCount(): Int = cartItems.size


    // ⭐ [추가] Helper 함수: 수량 및 가격을 업데이트하고 UI에 반영
    private fun updateItemTotal(holder: CartItemViewHolder, cartItem: CartItem) {
        val product = cartItem.product

        holder.name.text = product.name
        holder.unit.text = product.unit
        holder.image.setImageResource(product.imageResId)

        // 수량 표시
        holder.quantity.text = cartItem.quantity.toString()

        // 최종 가격 계산 및 표시 (수량 * 개당 가격)
        val finalPrice = product.price * cartItem.quantity
        holder.price.text = String.format("$%.2f", finalPrice)

        // 💡 참고: 장바구니 총액을 보여주는 TextView가 MyCartActivity에 있다면,
        // 이 함수 내에서 액티비티의 총액 업데이트 함수를 호출하는 콜백 로직도 필요합니다.
    }
}