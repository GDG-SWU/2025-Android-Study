package com.example.a2025_android_study

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView // ImageView 임포트 추가
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProductDetailActivity : AppCompatActivity() {

    private var currentQuantity: Int = 1
    private var unitPrice: Double = 0.0
    private lateinit var currentProduct: Product

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        // 1. Intent에서 모든 상품 데이터 수신
        val intent = intent
        val receivedPrice = intent.getDoubleExtra("UNIT_PRICE", 0.0)
        val productId = intent.getIntExtra("PRODUCT_ID", -1)
        val productName = intent.getStringExtra("PRODUCT_NAME") ?: "Product Name"

        // ⭐ [추가] 전달받은 이미지 ID 수신 (MainActivity에서 보낸 ID 재활용)
        val receivedImageResId = intent.getIntExtra("IMAGE_RES_ID", R.drawable.img_red_apple)

        unitPrice = receivedPrice

        // 🚨 장바구니에 추가할 Product 객체 생성 (전달받은 ID 사용)
        currentProduct = Product(
            id = productId,
            name = productName,
            unit = "1kg, Priceg", // 단위는 임시로 하드코딩
            price = unitPrice,
            imageResId = receivedImageResId // ⭐ [수정] 전달받은 ID를 사용합니다.
        )

        // 2. 뷰 연결 (Null safety)
        val quantityTextView: TextView? = findViewById(R.id.text_quantity)
        val priceTextView: TextView? = findViewById(R.id.text_price_detail)
        val plusButton: ImageButton? = findViewById(R.id.btn_quantity_plus)
        val minusButton: ImageButton? = findViewById(R.id.btn_quantity_minus)
        val addToBasketButton: Button? = findViewById(R.id.btn_add_to_basket)
        val backButton: ImageButton? = findViewById(R.id.btn_back_arrow)
        val nameTextView: TextView? = findViewById(R.id.text_detail_name)
        val unitTextView: TextView? = findViewById(R.id.text_detail_unit)

        // ⭐ [추가] 메인 이미지 뷰 연결
        val detailImageView: ImageView? = findViewById(R.id.img_product_main)


        // ------------------------------------------------------------------
        // 3. 필수 뷰 연결 확인 및 로직 실행
        // ------------------------------------------------------------------

        if (quantityTextView == null || priceTextView == null || detailImageView == null) {
            Toast.makeText(this, "레이아웃 초기화 오류: 필수 뷰 ID 누락", Toast.LENGTH_LONG).show()
            return
        }

        // 4. 초기 화면 데이터 설정 (null check를 이미 했으므로 non-null assertion 사용)
        nameTextView?.text = productName
        unitTextView?.text = currentProduct.unit

        // ⭐ [핵심 수정] 전달받은 ID를 ImageView에 적용
        detailImageView.setImageResource(currentProduct.imageResId)

        updatePrice(quantityTextView, priceTextView)

        // 5. 뒤로가기 버튼 기능
        backButton?.setOnClickListener {
            onBackPressed()
        }

        // 6. "Add To Basket" 버튼 클릭 리스너
        addToBasketButton?.setOnClickListener {
            CartManager.addItem(currentProduct, currentQuantity)

            val cartIntent = Intent(this, MyCartActivity::class.java)
            startActivity(cartIntent)
        }

        // 7. 수량 조절 버튼 로직
        plusButton?.setOnClickListener {
            currentQuantity++
            updatePrice(quantityTextView, priceTextView)
        }

        minusButton?.setOnClickListener {
            if (currentQuantity > 1) {
                currentQuantity--
                updatePrice(quantityTextView, priceTextView)
            }
        }
    }

    // 8. 가격 및 수량을 화면에 업데이트하는 함수 (NonNull 뷰를 받도록 변경)
    private fun updatePrice(quantityTextView: TextView, priceTextView: TextView) {
        quantityTextView.text = currentQuantity.toString()
        val finalPrice = currentQuantity * unitPrice
        priceTextView.text = String.format("$%.2f", finalPrice)
    }
}