package com.example.a2025_android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val name = intent.getStringExtra("name")
        val price = intent.getStringExtra("price")
        val imageRes = intent.getIntExtra("image", 0)

        val ivImage = findViewById<ImageView>(R.id.detail_image)
        val tvName = findViewById<TextView>(R.id.detail_name)
        val tvPrice = findViewById<TextView>(R.id.detail_price)

        tvName.text = name
        tvPrice.text = price
        if(imageRes != 0){
            ivImage.setImageResource(imageRes)
        }

        findViewById<ImageView>(R.id.btn_back).setOnClickListener{
            finish()
        }

        var quantity = 1
        val tvQuantity = findViewById<TextView>(R.id.quantity)
        val btnPlus = findViewById<ImageView>(R.id.btn_plus)
        val btnMinus = findViewById<ImageView>(R.id.btn_minus)

        btnPlus.setOnClickListener{
            quantity++
            tvQuantity.text = quantity.toString()
        }
        btnMinus.setOnClickListener {
            if (quantity >1 ){
            quantity--
            tvQuantity.text = quantity.toString()}
        }

        val layoutExpand = findViewById<LinearLayout>(R.id.layout_expand)
        val tvDesc = findViewById<TextView>(R.id.detail_desc)
        val ivArrow = findViewById<ImageView>(R.id.iv_arrow)

        layoutExpand.setOnClickListener {
            if(tvDesc.visibility == View.VISIBLE){
                tvDesc.visibility = View.GONE
                ivArrow.animate().rotation(0f).setDuration(300).start()
            }
            else{
                tvDesc.visibility = View.VISIBLE
                ivArrow.animate().rotation(180f).setDuration(300).start()
            }
        }
    }
}