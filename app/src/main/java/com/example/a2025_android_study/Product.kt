package com.example.a2025_android_study

data class Product(
    val imageResId: Int, // R.drawable.banana 처럼 이미지 리소스 ID (정수)
    val name: String,    // 상품명 (문자열)
    val description: String, // 상품 설명 (문자열)
    val price: String    // 가격 (문자열, 예: "$4.99")
)