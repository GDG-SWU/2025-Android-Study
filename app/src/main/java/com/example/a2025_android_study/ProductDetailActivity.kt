package com.example.a2025_android_study

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductDetailActivity : AppCompatActivity() {

    private var quantity = 1
    private var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        // 1. 뷰 가져오기
        val ivDetailImage = findViewById<ImageView>(R.id.iv_detail_image)
        val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
        val tvDetailDescShort = findViewById<TextView>(R.id.tv_detail_description_short)
        val tvDetailPrice = findViewById<TextView>(R.id.tv_detail_price)

        // ★ Intent로 넘어온 데이터 받기
        val imageResId = intent.getIntExtra("imageResId", 0)
        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val price = intent.getStringExtra("price")

        // ★ 받은 데이터 화면에 표시
        if (imageResId != 0) {
            ivDetailImage.setImageResource(imageResId)
        }
        tvDetailName.text = name ?: "Product Name"
        tvDetailDescShort.text = description ?: "Detail"
        tvDetailPrice.text = price ?: "$0.00"

        // ... (버튼 가져오기) ...
        val btnBack = findViewById<ImageView>(R.id.iv_back)
        val btnMinus = findViewById<ImageButton>(R.id.btn_minus)
        val btnPlus = findViewById<ImageButton>(R.id.btn_plus)
        val tvQuantity = findViewById<TextView>(R.id.tv_quantity)
        val ivFavorite = findViewById<ImageView>(R.id.iv_favorite)

        btnBack.setOnClickListener { finish() }

        btnPlus.setOnClickListener {
            quantity++
            tvQuantity.text = quantity.toString()
        }
        btnMinus.setOnClickListener {
            if (quantity > 1) {
                quantity--
                tvQuantity.text = quantity.toString()
            }
        }

        ivFavorite.setOnClickListener {
            if (isFavorite) {
                ivFavorite.setImageResource(R.drawable.fav)
                ivFavorite.setColorFilter(Color.parseColor("#7C7C7C"))
                isFavorite = false
            } else {
                ivFavorite.setImageResource(R.drawable.fav_filled)
                ivFavorite.setColorFilter(Color.RED)
                isFavorite = true
            }
        }

        tvQuantity.setOnClickListener {
            // 1. 입력 상자(EditText) 만들기
            val inputEdit = android.widget.EditText(this)
            inputEdit.inputType = android.text.InputType.TYPE_CLASS_NUMBER // 숫자 키패드만 뜨게 설정
            inputEdit.setText(quantity.toString()) // 현재 수량 보여주기
            inputEdit.gravity = android.view.Gravity.CENTER // 텍스트 가운데 정렬

            // 2. 팝업창(AlertDialog) 띄우기
            androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("Enter Quantity") // 팝업 제목
                .setMessage("Please enter the number of items.") // 안내 문구
                .setView(inputEdit) // 위에서 만든 입력 상자를 팝업에 넣기
                .setPositiveButton("OK") { _, _ ->
                    // OK 눌렀을 때 실행할 코드
                    val inputText = inputEdit.text.toString()

                    // 빈칸이 아니고, 숫자로 변환 가능하며, 0보다 큰 경우에만 적용
                    if (inputText.isNotEmpty()) {
                        val newQuantity = inputText.toIntOrNull()
                        if (newQuantity != null && newQuantity > 0) {
                            quantity = newQuantity
                            tvQuantity.text = quantity.toString()
                        }
                    }
                }
                .setNegativeButton("Cancel", null) // 취소 누르면 아무것도 안 함
                .show()
        }

        // Product Detail 섹션만 접기/펴기 적용
        setupExpandableSection(
            findViewById(R.id.layout_detail_header),
            findViewById(R.id.iv_detail_arrow),
            findViewById(R.id.tv_detail_content)
        )

        // ============================================================
        // ★ [수정됨] 장바구니 담기 버튼 로직을 onCreate 안으로 가져왔습니다.
        // ============================================================

        val btnAddToBasket = findViewById<com.google.android.material.button.MaterialButton>(R.id.btn_add_to_basket)

        btnAddToBasket.setOnClickListener {
            // (A) 현재 화면의 상품 정보 생성
            val currentProduct = Product(
                imageResId = intent.getIntExtra("imageResId", 0),
                name = tvDetailName.text.toString(),
                description = tvDetailDescShort.text.toString(),
                price = tvDetailPrice.text.toString()
            )

            // (B) CartManager에 추가
            CartManager.addProduct(currentProduct, quantity)

            // (C) CartActivity로 이동
            val intent = android.content.Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

    } // onCreate 함수는 여기서 끝납니다.

    // ... (setupExpandableSection 함수는 onCreate 밖에 있어야 합니다)
    private fun setupExpandableSection(header: View, arrow: ImageView, content: View) {
        header.setOnClickListener {
            if (content.visibility == View.VISIBLE) {
                content.visibility = View.GONE
                arrow.setImageResource(R.drawable.more_click_before)
            } else {
                content.visibility = View.VISIBLE
                arrow.setImageResource(R.drawable.more_click_after)
            }
        }
    }
}