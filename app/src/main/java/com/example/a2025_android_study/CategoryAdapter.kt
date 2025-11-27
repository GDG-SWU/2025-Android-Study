package com.example.a2025_android_study

import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

// R, Category 클래스는 같은 패키지에 있으므로 별도 import 필요 없습니다.

class CategoryAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    // 뷰 홀더: item_category_card.xml 내부의 뷰들을 연결하는 역할
    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val backgroundLayout: View = itemView.findViewById(R.id.category_card_background)
        val name: TextView = itemView.findViewById(R.id.text_category_name)
        val image: ImageView = itemView.findViewById(R.id.img_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category_card, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        val context = holder.itemView.context

        holder.name.text = category.name
        holder.image.setImageResource(category.imageResId)

        // 1. 배경/테두리 색상 ID 쌍 가져오기
        val colorResourcePair = getColorResourcePair(category.backgroundColor)
        val color25Id = colorResourcePair.first   // 25% 투명 색상 ID (배경)
        val colorFullId = colorResourcePair.second // 100% 불투명 색상 ID (테두리)

        // 2. 배경 (25% 투명) 적용
        val color25 = ContextCompat.getColor(context, color25Id)
        holder.backgroundLayout.setBackgroundColor(color25)

        // 3. 테두리 (100% 불투명) 적용
        // backgroundLayout에 적용된 Drawable을 가져와 Stroke 색상을 동적으로 변경합니다.
        val drawable = holder.backgroundLayout.background
        if (drawable is GradientDrawable) {
            val colorFull = ContextCompat.getColor(context, colorFullId)
            // 1dp 테두리 두께 설정 (R.dimen.stroke_width_1dp 리소스 필요)
            val strokeWidth = context.resources.getDimensionPixelSize(R.dimen.stroke_width_1dp)
            drawable.setStroke(strokeWidth, colorFull)
        }

        // 🚨 [수정] 클릭 리스너를 완전히 제거했습니다.
    }

    // 💡 [Helper] 기본 색상 ID를 받아 FULL과 25% 투명도 ID를 반환
    private fun getColorResourcePair(baseColorId: Int): Pair<Int, Int> {
        // 이 로직은 colors.xml에 정의된 _25 와 _full 색상 ID에 의존합니다.
        return when (baseColorId) {
            R.color.cat_green -> Pair(R.color.cat_green_25, R.color.cat_green_full)
            R.color.cat_orange -> Pair(R.color.cat_orange_25, R.color.cat_orange_full)
            R.color.cat_pink -> Pair(R.color.cat_pink_25, R.color.cat_pink_full)
            R.color.cat_purple -> Pair(R.color.cat_purple_25, R.color.cat_purple_full)
            R.color.cat_yellow -> Pair(R.color.cat_yellow_25, R.color.cat_yellow_full)
            R.color.cat_blue -> Pair(R.color.cat_blue_25, R.color.cat_blue_full)
            else -> Pair(R.color.white, R.color.black)
        }
    }

    override fun getItemCount(): Int = categories.size
}