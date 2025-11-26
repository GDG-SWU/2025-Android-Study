package com.example.a2025_android_study

data class Product(
    val imageResId: Int, // R.drawable.banana 처럼 이미지 리소스 ID
    val name: String,    // 상품명
    val description: String, // 상품 설명
    val price: String    // 가격
)