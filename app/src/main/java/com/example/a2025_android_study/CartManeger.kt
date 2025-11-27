package com.example.a2025_android_study

// Product.kt와 CartItem.kt는 이미 생성되어 있어야 합니다.
data class CartItem(
    val product: Product,
    var quantity: Int
)

object CartManager {
    // 내부 목록은 remove 작업이 가능하도록 MutableList여야 합니다.
    private val _cartItems = mutableListOf<CartItem>()

    // 외부에서 수정 불가능한 리스트를 제공합니다.
    val cartItems: List<CartItem> get() = _cartItems

    // ⭐ [추가] 장바구니에 담긴 전체 상품 개수를 반환합니다.
    val totalItemCount: Int
        get() = _cartItems.sumOf { it.quantity }

    // ⭐ [추가] 장바구니에 담긴 상품들의 최종 총액을 계산하여 반환합니다.
    val totalCost: Double
        get() = _cartItems.sumOf { it.product.price * it.quantity }


    fun addItem(product: Product, quantity: Int) {
        // [수정] 상품 ID 뿐만 아니라, 상품의 고유성을 확인해야 합니다.
        val existingItem = _cartItems.find { it.product.id == product.id }

        if (existingItem != null) {
            // 이미 있는 상품이면 수량만 업데이트
            existingItem.quantity += quantity
        } else {
            // 새로운 상품이면 목록에 추가
            _cartItems.add(CartItem(product, quantity))
        }
    }

    // 장바구니에서 아이템을 제거하는 함수
    fun removeItem(item: CartItem) {
        _cartItems.remove(item)
    }

    fun clearCart() {
        _cartItems.clear()
    }
}