package com.example.a2025_android_study

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1) 섹션 타이틀
        setupSectionTitle(R.id.header_exclusive, "Exclusive Offer")
        setupSectionTitle(R.id.header_best_selling, "Best Selling")
        setupSectionTitle(R.id.header_groceries, "Groceries")

        // 2) Exclusive Offer 데이터
        val exclusiveOfferProducts = listOf(
            Product(1, "Organic Bananas", "7pcs, Priceg", 4.99, R.drawable.apple),
            Product(2, "Red Apple", "1kg, Priceg", 4.99, R.drawable.apple),
            Product(3, "Grapes", "500gm, Priceg", 3.50, R.drawable.apple),
            Product(4, "Mangoes", "1kg, Priceg", 6.50, R.drawable.apple),
            Product(5, "Pears", "5pcs, Priceg", 4.00, R.drawable.apple)
        )
        initHorizontalList(
            recyclerId = R.id.rv_exclusive_offer,
            items = exclusiveOfferProducts
        )

        // 3) Best Selling 데이터
        val bestSellingProducts = listOf(
            Product(101, "Bell Pepper Red", "1kg, Priceg", 4.99, R.drawable.bell_pepper_red),
            Product(102, "Ginger", "250gm, Priceg", 4.99, R.drawable.bell_pepper_red),
            Product(103, "Pears", "5pcs, Priceg", 4.00, R.drawable.apple)

        )
        initHorizontalList(
            recyclerId = R.id.rv_best_selling,
            items = bestSellingProducts
        )

        // 4) Groceries 데이터
        val groceryProducts = listOf(
            Product(201, "Beef Bone", "1kg, Priceg", 4.99, R.drawable.beef_bone),
            Product(202, "Broiler Chicken", "1kg, Priceg", 4.99, R.drawable.broiler_chicken),
            Product(203, "Pears", "5pcs, Priceg", 4.00, R.drawable.apple)

        )
        initHorizontalList(
            recyclerId = R.id.rv_groceries,
            items = groceryProducts
        )
    }

    // 섹션 제목 공통 설정
    private fun setupSectionTitle(includeId: Int, titleText: String) {
        val container = findViewById<View?>(includeId)
        val titleView = container?.findViewById<TextView>(R.id.text_section_title)
        titleView?.text = titleText
    }

    // RecyclerView 공통 초기화
    private fun initHorizontalList(recyclerId: Int, items: List<Product>) {
        val recycler = findViewById<RecyclerView?>(recyclerId) ?: return
        recycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler.adapter = ExclusiveOfferAdapter(items)
    }
}
