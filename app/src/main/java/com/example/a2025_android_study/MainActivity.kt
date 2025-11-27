package com.example.a2025_android_study

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.a2025_android_study.ExploreActivity
import com.example.a2025_android_study.MyCartActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1) 섹션 타이틀 설정
        setupSectionTitle(R.id.header_exclusive, "Exclusive Offer")
        setupSectionTitle(R.id.header_best_selling, "Best Selling")
        setupSectionTitle(R.id.header_groceries, "Groceries")

        // 2) Exclusive Offer 데이터 - (요청대로 고정)
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

        // 3) Best Selling 데이터 - (요청대로 고정)
        val bestSellingProducts = listOf(
            Product(101, "Bell Pepper Red", "1kg, Priceg", 4.99, R.drawable.bell_pepper_red),
            Product(102, "Ginger", "250gm, Priceg", 4.99, R.drawable.bell_pepper_red),
            Product(103, "Pears", "5pcs, Priceg", 4.00, R.drawable.apple)
        )
        // 🚨 Best Selling도 수평 목록으로 유지 (요청대로 initHorizontalList 호출 유지)
        initHorizontalList(
            recyclerId = R.id.rv_best_selling,
            items = bestSellingProducts
        )

        // 4) Groceries 데이터 - (요청대로 고정)
        val groceryProducts = listOf(
            Product(201, "Beef Bone", "1kg, Priceg", 4.99, R.drawable.beef_bone),
            Product(202, "Broiler Chicken", "1kg, Priceg", 4.99, R.drawable.broiler_chicken),
            Product(203, "Pears", "5pcs, Priceg", 4.00, R.drawable.apple)
        )
        // 🚨 Groceries도 수평 목록으로 유지 (요청대로 initHorizontalList 호출 유지)
        initHorizontalList(
            recyclerId = R.id.rv_groceries,
            items = groceryProducts
        )

        // Bottom Navigation Listener 설정 ⭐ (이전 요청대로 추가)
        setupBottomNavigation()
    }

    // ----------------------------------------------------
    // --- 헬퍼 함수 정의 ---
    // ----------------------------------------------------

    // 섹션 제목 공통 설정
    private fun setupSectionTitle(includeId: Int, titleText: String) {
        val container = findViewById<View?>(includeId)
        val titleView = container?.findViewById<TextView>(R.id.text_section_title)
        titleView?.text = titleText
    }

    // 1. 수평 목록 (Exclusive Offer, Groceries, Best Selling) 초기화
    private fun initHorizontalList(recyclerId: Int, items: List<Product>) {
        val recycler = findViewById<RecyclerView?>(recyclerId) ?: return
        recycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler.adapter = ExclusiveOfferAdapter(items)
    }

    // 2. [추가] Bottom Navigation Listener 설정 함수
    private fun setupBottomNavigation() {
        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_fixed_nav)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_shop -> true // 현재 화면

                R.id.nav_explore -> {
                    val intent = Intent(this, ExploreActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_cart -> {
                    val intent = Intent(this, MyCartActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_favourite -> true
                R.id.nav_account -> true
                else -> false
            }
        }

        // 앱 실행 시 기본 탭을 'Shop'으로 설정
        bottomNav.selectedItemId = R.id.nav_shop
    }
}