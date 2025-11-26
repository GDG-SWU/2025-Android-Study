package com.example.a2025_android_study

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // [1] 뒤로가기 버튼 기능
        val btnBack = findViewById<ImageView>(R.id.iv_back)
        btnBack.setOnClickListener {
            finish() // 현재 화면 종료 (이전 화면으로 돌아감)
        }

        // [2] 리사이클러뷰 설정
        val rvCart = findViewById<RecyclerView>(R.id.rv_cart)
        val cartAdapter = CartAdapter(CartManager.getCartList()) {
            // 데이터 변경 시 (수량 조절/삭제) 처리할 내용이 있다면 여기에 작성
            // 예: 총액 업데이트 함수 호출
        }
        rvCart.layoutManager = LinearLayoutManager(this)
        rvCart.adapter = cartAdapter

        // [3] 하단 네비게이션 설정
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_cart // Cart 탭 활성화 표시

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_shop -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    // 기존에 쌓인 액티비티들을 정리하고 홈으로 가는 것이 좋을 수 있음
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.nav_explore -> {
                    val intent = Intent(this, ExploreActivity::class.java)
                    startActivity(intent)
                    finish() // Cart 화면은 닫고 이동
                    true
                }
                R.id.nav_cart -> true // 현재 화면이므로 아무것도 안 함
                // 다른 탭(Favourite, Account)은 필요 시 추가
                else -> false
            }
        }
    }
}