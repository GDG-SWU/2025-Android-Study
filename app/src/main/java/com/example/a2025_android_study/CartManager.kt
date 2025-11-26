package com.example.a2025_android_study

// 장바구니 아이템 모델
data class CartItem(
    val product: Product,
    var quantity: Int
)

object CartManager {
    private val cartList = mutableListOf<CartItem>()

    fun addProduct(product: Product, count: Int) {
        val existingItem = cartList.find { it.product.name == product.name }
        if (existingItem != null) {
            existingItem.quantity += count
        } else {
            cartList.add(CartItem(product, count))
        }
    }

    // [NEW] 수량 1개 증가
    fun increaseQuantity(position: Int) {
        cartList[position].quantity++
    }

    // [NEW] 수량 1개 감소 (1개일 때는 감소 안 함)
    fun decreaseQuantity(position: Int) {
        if (cartList[position].quantity > 1) {
            cartList[position].quantity--
        }
    }

    // [NEW] 상품 삭제
    fun removeProduct(position: Int) {
        cartList.removeAt(position)
    }

    fun getCartList(): List<CartItem> {
        return cartList
    }
}