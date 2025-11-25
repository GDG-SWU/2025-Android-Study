package com.example.a2025_android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productList = ArrayList<Product>()
        productList.add(Product("Organic Bananas", "7pcs, Priceg", "$4.99", R.drawable.banana))
        productList.add(Product("Red Apples", "1kg, Priceg", "$4.99", R.drawable.apple))
        productList.add(Product("Bell Pepper Red", "1kg, Priceg", "$4.99", R.drawable.red_pepper))
        productList.add(Product("Ginger", "250g, Priceg", "$4.99", R.drawable.ginger))

        val groceryList = ArrayList<Grocery>()
        groceryList.add(Grocery("Pulses", R.drawable.pulses, "#80F8A44C"))
        groceryList.add(Grocery("Rice", R.drawable.rice, "#8053B175"))

        val grocery_adapter = GroceryAdapter(groceryList)
        val product_adapter = ProductAdapter(productList)
        val rvExclusive = findViewById<RecyclerView>(R.id.rv_exclusive_offer)
        rvExclusive.adapter = product_adapter

        val rvBestSelling = findViewById<RecyclerView>(R.id.rv_best_selling)
        rvBestSelling.adapter = product_adapter

        val rvGroceries = findViewById<RecyclerView>(R.id.rv_groceries)
        rvGroceries.adapter = grocery_adapter
    }

}