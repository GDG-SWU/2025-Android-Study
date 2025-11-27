package com.example.a2025_android_study

// Category.kt
data class Category(
    val id: Int,
    val name: String,       // 카테고리 이름
    val imageResId: Int,    // 카테고리 이미지
    val backgroundColor: Int // 카드 배경색 (R.color.xxx)
)