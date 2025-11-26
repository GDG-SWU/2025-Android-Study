package com.example.a2025_android_study

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.nav_shop -> true
                R.id.nav_explore -> {
                    val intent = Intent(this, ExploreActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_cart -> true
                R.id.nav_fav -> true
                R.id.nav_account -> true
                else -> false
            }
        }

        val searchView = findViewById<SearchView>(R.id.search_view)
        val searchEditText = searchView.findViewById<SearchView.SearchAutoComplete>(
            androidx.appcompat.R.id.search_src_text
        )
        searchEditText.setHintTextColor(Color.parseColor("#B2B2B2"))
        searchEditText.setTextColor(Color.parseColor("#222222"))
        searchEditText.background = null

        val searchIcon = searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_mag_icon)
        searchIcon.layoutParams.width = 24
        searchIcon.layoutParams.height = 24
        searchIcon.scaleType = ImageView.ScaleType.CENTER_INSIDE

        val rvExclusive = findViewById<RecyclerView>(R.id.rv_exclusive)
        val rvBestSelling = findViewById<RecyclerView>(R.id.rv_best_selling)
        val rvCategories = findViewById<RecyclerView>(R.id.rv_categories)
        val rvProducts = findViewById<RecyclerView>(R.id.rv_products)

        // 샘플 데이터
        val exclusiveOfferList = listOf(
            Product("Organic Bananas", "7pcs, Priceg", "$4.99", R.drawable.banana),
            Product("Red Apple", "1kg, Priceg", "$4.99", R.drawable.apple_product),
            Product("Organic Bananas", "7pcs, Priceg", "$4.99", R.drawable.banana),
            Product("Red Apple", "1kg, Priceg", "$4.99", R.drawable.apple_product)
        )

        val bestSellingList = listOf(
            Product("Bell Pepper Red", "1kg, Priceg", "$4.99", R.drawable.pepperred),
            Product("Ginger", "250gm, Priceg", "$4.99", R.drawable.ginger),
            Product("Bell Pepper Red", "1kg, Priceg", "$4.99", R.drawable.pepperred),
            Product("Ginger", "250gm, Priceg", "$4.99", R.drawable.ginger)
        )

        val groceriesList = listOf(
            Product("Beef Bone", "1kg, Priceg", "$4.99", R.drawable.beef),
            Product("Broiler Chicken", "1kg, Priceg", "$4.99", R.drawable.chicken),
            Product("Beef Bone", "1kg, Priceg", "$4.99", R.drawable.beef),
            Product("Broiler Chicken", "1kg, Priceg", "$4.99", R.drawable.chicken)
        )

        rvExclusive.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvExclusive.adapter = ProductAdapter(exclusiveOfferList){
            product -> openDetail(product)
        }

        rvBestSelling.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvBestSelling.adapter = ProductAdapter(bestSellingList){
                product -> openDetail(product)
        }

        rvProducts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvProducts.adapter = ProductAdapter(groceriesList){
                product -> openDetail(product)
        }

        // Category 샘플 데이터
        val categoryList = listOf(
            Category("Pulses", R.drawable.pules, Color.parseColor("#D9F8A44C")),
            Category("Rice", R.drawable.rice, Color.parseColor("#D953B175"))
        )

        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = CategoryAdapter(categoryList)
    }

    private fun openDetail(product: Product) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("name", product.title)
        intent.putExtra("qty", product.subTitle)
        intent.putExtra("price", product.price)
        intent.putExtra("image", product.imageRes)
        startActivity(intent)
    }
}
