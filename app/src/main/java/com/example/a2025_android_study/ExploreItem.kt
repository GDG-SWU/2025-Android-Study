package com.example.a2025_android_study

data class ExploreItem(
    val name: String,           // 카테고리 이름 (예: "Fresh Fruits")
    val imageResId: Int,        // 이미지 리소스 ID (예: R.drawable.find_fruits)
    val backgroundColor: String, // 배경색 Hex 코드 (예: "#53B175")
    val borderColor: String      // 테두리색 Hex 코드 (예: "#53B175")
)