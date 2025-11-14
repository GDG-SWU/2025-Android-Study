package com.example.a2025_android_study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager // 1. LinearLayoutManager 임포트
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // 1. 어댑터 인스턴스 4개 생성
        val exclusiveOfferAdapter = ProductAdapter()
        val bestSellingAdapter = ProductAdapter()
        val categoryAdapter = CategoryAdapter()
        val bottomProductsAdapter = ProductAdapter()

        // 2. XML의 RecyclerView 뷰 4개 찾기
        val rvExclusiveOffer = findViewById<RecyclerView>(R.id.rv_exclusive_offer)
        val rvBestSelling = findViewById<RecyclerView>(R.id.rv_best_selling)
        val rvCategories = findViewById<RecyclerView>(R.id.rv_categories)
        val rvBottomProducts = findViewById<RecyclerView>(R.id.rv_bottom_products)

        // 3. RecyclerView에 LayoutManager와 어댑터 4개 연결

        // --- 이 부분이 핵심입니다! ---
        rvExclusiveOffer.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvExclusiveOffer.adapter = exclusiveOfferAdapter

        rvBestSelling.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvBestSelling.adapter = bestSellingAdapter

        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoryAdapter

        rvBottomProducts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvBottomProducts.adapter = bottomProductsAdapter
        // --- 여기까지 ---

        // 4. 샘플 데이터 생성
        // (R.drawable.banana, R.drawable.apple 등이 drawable 폴더에 있어야 합니다!)

        val exclusiveOfferList = listOf(
            Product(R.drawable.banana, "Organic Bananas", "7pcs, Priceg", "$4.99"),
            Product(R.drawable.apple, "Red Apple", "1kg, Priceg", "$4.99")
        )

        val bestSellingList = listOf(
            Product(R.drawable.bellpepper, "Bell Pepper Red", "1kg, Priceg", "$4.99"),
            Product(R.drawable.ginger, "Ginger", "250gm, Priceg", "$4.99")
        )

        val categoryList = listOf(
            Category(R.drawable.pulses, "Pulses", R.color.pulses_bg),
            Category(R.drawable.rice, "Rice", R.color.rice_bg)
        )

        val bottomProductList = listOf(
            Product(R.drawable.beefbone, "Beef Bone", "1kg, PriceG", "$4.99"),
            Product(R.drawable.broilerchicken, "Broiler Chicken", "1kg, PriceG", "$4.99")
        )

        // 5. 어댑터에 데이터 리스트 제출
        exclusiveOfferAdapter.submitList(exclusiveOfferList)
        bestSellingAdapter.submitList(bestSellingList)
        categoryAdapter.submitList(categoryList)
        bottomProductsAdapter.submitList(bottomProductList)
    }
}