package com.example.a2025_android_study

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class ExploreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore)

        // ⭐ [수정] 모든 초기화 코드가 onCreate 함수 내부로 들어왔습니다.

        // 1. 샘플 카테고리 데이터 생성
        val sampleCategories = listOf(
            // R.drawable과 R.color는 프로젝트에 해당 리소스가 있어야 합니다.
            Category(1, "Fresh Fruits & Vegetable", R.drawable.img_fresh_fruits, R.color.cat_green),
            Category(2, "Cooking Oil & Ghee", R.drawable.img_cooking_oil, R.color.cat_orange),
            Category(3, "Meat & Fish", R.drawable.img_meat, R.color.cat_pink),
            Category(4, "Bakery & Snacks", R.drawable.img_bakery, R.color.cat_purple),
            Category(5, "Dairy & Eggs", R.drawable.img_dairy, R.color.cat_yellow),
            Category(6, "Beverages", R.drawable.img_beverages, R.color.cat_blue)
        )

        // 2. RecyclerView 연결 및 레이아웃 설정
        val rvCategories: RecyclerView = findViewById(R.id.rv_categories)
        rvCategories.layoutManager = GridLayoutManager(this, 2) // 2열 그리드 설정

        // 3. 어댑터 연결
        val adapter = CategoryAdapter(sampleCategories)
        rvCategories.adapter = adapter

        val intent = Intent(this, ExploreActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        }
        //바탐바 연결

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_fixed_nav)
        bottomNav.selectedItemId = R.id.nav_explore

        startActivity(intent)
    }
}