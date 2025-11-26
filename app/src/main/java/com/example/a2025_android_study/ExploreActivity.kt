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

        // 1. 어댑터 생성
        val exploreAdapter = ExploreAdapter()

        // 2. RecyclerView 설정
        val rvExplore = findViewById<RecyclerView>(R.id.rv_explore)
        rvExplore.layoutManager = GridLayoutManager(this, 2) // spanCount = 2
        rvExplore.adapter = exploreAdapter

        // 3. 데이터 생성 (이름, 이미지, 배경색, 테두리색)
        val exploreList = listOf(
            ExploreItem("Fresh Fruits\n& Vegetable", R.drawable.find_fruites_vegetables, "#EEF8F2", "#53B175"), // 초록
            ExploreItem("Cooking Oil\n& Ghee", R.drawable.find_oil, "#FFF6EE", "#F8A44C"),       // 주황
            ExploreItem("Meat & Fish", R.drawable.find_meat_fish, "#FDE8E4", "#F7A593"),         // 분홍
            ExploreItem("Bakery & Snacks", R.drawable.find_bread_snack, "#F4EBF7", "#D3B0E0"),   // 보라 (색상값 임의 조정 필요할 수 있음)
            ExploreItem("Dairy & Eggs", R.drawable.find_dairy_egg, "#FEF8E5", "#FDE598"),        // 노랑
            ExploreItem("Beverages", R.drawable.find_beverages, "#EDF7FC", "#B7DFF5")            // 파랑
        )

        // 4. 데이터 제출
        exploreAdapter.submitList(exploreList)

        // 5. 하단 네비게이션 연결 (Explore 탭이 선택된 상태로 보이게 설정)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_explore // Explore 탭 활성화

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_shop -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish() // 현재 화면 종료하고 홈으로 이동
                    true
                }
                R.id.nav_explore -> true
                // 다른 탭(Cart, Favourite, Account)도 나중에 연결
                else -> false
            }
        }
    }
}