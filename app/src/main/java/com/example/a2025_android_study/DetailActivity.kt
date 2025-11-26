package com.example.a2025_android_study

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    var isProductDetailOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Product Detail
        val layoutProductDetail = findViewById<LinearLayout>(R.id.layout_product_detail)
        val arrowProductDetail = findViewById<ImageView>(R.id.ic_arrow_product_detail)
        val hiddenProductDetail = findViewById<TextView>(R.id.detail_hidden_product)

        // Product Detail toggle
        layoutProductDetail.setOnClickListener {
            isProductDetailOpen = !isProductDetailOpen

            if (isProductDetailOpen) {
                hiddenProductDetail.visibility = View.VISIBLE
                arrowProductDetail.setImageResource(R.drawable.ic_arrow_down)
            } else {
                hiddenProductDetail.visibility = View.GONE
                arrowProductDetail.setImageResource(R.drawable.ic_arrow)
            }
        }

        // intent 값 설정
        val iv = findViewById<ImageView>(R.id.detail_image)
        val tvName = findViewById<TextView>(R.id.detail_name)
        val tvQty = findViewById<TextView>(R.id.detail_qty)
        val tvPrice = findViewById<TextView>(R.id.detail_price)

        val name = intent.getStringExtra("name")
        val qty = intent.getStringExtra("qty")
        val price = intent.getStringExtra("price")
        val image = intent.getIntExtra("image", 0)

        iv.setImageResource(image)
        tvName.text = name
        tvQty.text = qty
        tvPrice.text = price

        // CartActivity로 이동
        val btnAddToBasket = findViewById<TextView>(R.id.btn_add_to_basket)
        btnAddToBasket.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java).apply {
                putExtra("name", name)
                putExtra("qty", qty)
                putExtra("price", price)
                putExtra("image", image)
            }
            startActivity(intent)
        }
    }
}
