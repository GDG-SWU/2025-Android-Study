package com.example.a2025_android_study

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val container = findViewById<LinearLayout>(R.id.cart_item_container)

        // DetailActivity에서 전달된 상품 정보
        val name = intent.getStringExtra("name") ?: return
        val qty = intent.getIntExtra("qty", 1)
        val priceStr = intent.getStringExtra("price") ?: "$0.00"
        val imageRes = intent.getIntExtra("image", 0)

        // 가격에서 숫자만 추출
        val pricePerItem = priceStr.replace("$", "").toDoubleOrNull() ?: 0.0

        // Cart Item View를 동적으로 추가
        val itemView = LayoutInflater.from(this).inflate(R.layout.item_cart, container, false)

        val ivImage = itemView.findViewById<ImageView>(R.id.cart_item_image)
        val tvName = itemView.findViewById<TextView>(R.id.cart_item_name)
        val tvQtyDisplay = itemView.findViewById<TextView>(R.id.cart_item_qty)
        val tvPrice = itemView.findViewById<TextView>(R.id.cart_item_price)

        val btnDecrease = itemView.findViewById<Button>(R.id.btn_decrease)
        val btnIncrease = itemView.findViewById<Button>(R.id.btn_increase)
        val tvQty = itemView.findViewById<TextView>(R.id.cart_qty)
        val btnRemove = itemView.findViewById<ImageView>(R.id.btn_remove)

        ivImage.setImageResource(imageRes)
        tvName.text = name
        tvQty.text = qty.toString()
        tvQtyDisplay.text = "Quantity: $qty"
        tvPrice.text = "$${pricePerItem * qty}"

        // + 버튼 클릭
        btnIncrease.setOnClickListener {
            var currentQty = tvQty.text.toString().toInt()
            currentQty++
            tvQty.text = currentQty.toString()
            tvQtyDisplay.text = "Quantity: $currentQty"
            tvPrice.text = "$${pricePerItem * currentQty}"
        }

        // - 버튼 클릭
        btnDecrease.setOnClickListener {
            var currentQty = tvQty.text.toString().toInt()
            if (currentQty > 1) {
                currentQty--
                tvQty.text = currentQty.toString()
                tvQtyDisplay.text = "Quantity: $currentQty"
                tvPrice.text = "$${pricePerItem * currentQty}"
            }
        }

        // 삭제 버튼 클릭
        btnRemove.setOnClickListener {
            container.removeView(itemView)
        }

        container.addView(itemView)
    }
}
