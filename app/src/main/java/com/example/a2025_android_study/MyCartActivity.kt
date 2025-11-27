package com.example.a2025_android_study // ⭐ 본인의 실제 패키지명으로 변경

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a2025_android_study.R // R 클래스 임포트 확인
import com.google.android.material.bottomnavigation.BottomNavigationView

class MyCartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 장바구니 화면의 레이아웃 연결
        setContentView(R.layout.activity_my_cart)

        // 뷰 연결
        val rvCartItems: RecyclerView = findViewById(R.id.rv_cart_items)
        val titleTextView: TextView = findViewById(R.id.text_my_cart_title)

        titleTextView.text = "My Cart" // 제목 설정

        // 1. CartManager에서 데이터 가져오기
        val cartItems = CartManager.cartItems

        // 2. 어댑터 생성 및 연결 (MyCartAdapter는 새로 만들어야 합니다!)
        // 🚨 MyCartAdapter 클래스가 먼저 존재해야 합니다.
        val cartAdapter = MyCartAdapter(cartItems)

        // 3. RecyclerView 설정 (수직 목록)
        rvCartItems.layoutManager = LinearLayoutManager(this)
        rvCartItems.adapter = cartAdapter

        // (선택 사항) 장바구니가 비어 있을 때 처리 로직 추가
        if (cartItems.isEmpty()) {
            // 예를 들어, 장바구니가 비어있다는 텍스트를 보이게 하거나, Checkout 버튼을 숨기는 등의 처리
        }

        //바탐바 연결

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_fixed_nav)

        bottomNav.selectedItemId = R.id.nav_explore
    }
}