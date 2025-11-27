package com.example.a2025_android_study

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
// Product 클래스는 같은 패키지에 있으므로 별도 import가 필요하지 않습니다.
// ProductDetailActivity는 같은 패키지에 있다고 가정하고 import합니다.
import com.example.a2025_android_study.ProductDetailActivity


class ExclusiveOfferAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<ExclusiveOfferAdapter.ProductViewHolder>() {

    // ProductViewHolder를 하나로 통합합니다.
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // 1. View 요소 연결
        val name: TextView = itemView.findViewById(R.id.text_product_name)
        val unit: TextView = itemView.findViewById(R.id.text_product_unit)
        val price: TextView = itemView.findViewById(R.id.text_price)
        val image: ImageView = itemView.findViewById(R.id.img_product)


        // 2. 클릭 리스너 설정 (클릭 시 Detail Activity로 이동)
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val product = products[position]

                    // ⭐ [수정] Intent 생성 로직을 한 번만 실행하고 IMAGE_RES_ID를 추가합니다.
                    val intent = Intent(itemView.context, ProductDetailActivity::class.java).apply {
                        putExtra("PRODUCT_ID", product.id)
                        putExtra("PRODUCT_NAME", product.name)
                        putExtra("UNIT_PRICE", product.price)
                        // ⭐ IMAGE_RES_ID 전달 (치킨/사과 이미지 동적 로딩을 위해 필수)
                        putExtra("IMAGE_RES_ID", product.imageResId)
                    }
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product_card, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]

        holder.name.text = product.name
        holder.unit.text = product.unit
        // 가격 포맷팅은 Kotlin에서 String.format을 사용하는 것이 좋습니다.
        holder.price.text = String.format("$%.2f", product.price)
        holder.image.setImageResource(product.imageResId)
    }

    override fun getItemCount(): Int = products.size
}