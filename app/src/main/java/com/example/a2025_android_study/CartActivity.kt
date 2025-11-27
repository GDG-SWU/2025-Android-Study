package com.example.a2025_android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val cartList = ArrayList<CartItem>()

        cartList.add(CartItem("Bell Pepper Red", "1kg, Priceg", "$4.99", R.drawable.red_pepper,1))
        cartList.add(CartItem("Organic Bananas", "7pcs, Priceg", "$4.99", R.drawable.banana,1))
        cartList.add(CartItem("Red Apples", "1kg, Priceg", "$4.99", R.drawable.apple,1))
        cartList.add(CartItem("Ginger", "250g, Priceg", "$4.99", R.drawable.ginger,1))

        val cartAdapter = CartAdapter(cartList)
        val rvCart = findViewById<RecyclerView>(R.id.cart_item)

        rvCart.layoutManager = LinearLayoutManager(this)
        rvCart.adapter = cartAdapter
    }
}