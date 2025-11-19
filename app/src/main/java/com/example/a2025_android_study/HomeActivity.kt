package com.example.a2025_android_study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //1. 어댑터 인스턴스 4개 생성
        val exclusiveOfferAdapter = ProductAdapter()
        val bestSellingAdapter = ProductAdapter()
        val groceryAdapter = CategoryAdapter()
        val meatAdapter = ProductAdapter()

        //2. xml의 RecyclerView 뷰 4개 찾기
        //일단은 빈 틀을 가져오는것
        val rvExclusiveOffer = findViewById<RecyclerView>(R.id.rv_exclusive_offer)
        val rvBestSelling = findViewById<RecyclerView>(R.id.rv_best_selling)
        val rvGroceries = findViewById<RecyclerView>(R.id.rv_groceries)
        val rvMeat = findViewById<RecyclerView>(R.id.rv_meat)

        //3. RecyclerView에 LayoutManager와 어댑터 연결하기
        //RecyclerView는 재활용 가능한 뷰로, 처음은 그냥 빈 틀임.
        //따라서 LayoutManager와 어댑터를 사용해야함.
        //LayoutManager는 배치를 담당하며,
        //어댑터는 사진 파일과 글자를 item_product.xml에 담아서 출력할 수 있도록 해줌

        //RecyclerView에서 가로로 움직이라고 규칙주기
        rvExclusiveOffer.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        //RecyclerView에게 어댑터가 만든거 올리라고 지정
        rvExclusiveOffer.adapter = exclusiveOfferAdapter

        rvBestSelling.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvBestSelling.adapter = bestSellingAdapter

        rvGroceries.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvGroceries.adapter = groceryAdapter

        rvMeat.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvMeat.adapter = meatAdapter


        // 4. 샘플 데이터 생성

        val exclusiveOfferList = listOf(
            Product(R.drawable.banana, "Organic Bananas", "7pcs, Priceg", "$4.99"),
            Product(R.drawable.apple, "Red Apple", "1kg, Priceg", "$4.99"),
            // 스크롤 확인을 위해 데이터 추가
            Product(R.drawable.beefbone, "Beef Bone", "1kg, Priceg", "$4.99"),
            Product(R.drawable.broilerchicken, "Chicken", "1kg, Priceg", "$4.99")
        )

        val bestSellingList = listOf(
            Product(R.drawable.bellpepper, "Bell Pepper Red", "1kg, Priceg", "$4.99"),
            Product(R.drawable.ginger, "Ginger", "250gm, Priceg", "$4.99"),
            // 스크롤 확인을 위해 데이터 추가
            Product(R.drawable.banana, "Organic Bananas", "7pcs, Priceg", "$4.99"),
            Product(R.drawable.apple, "Red Apple", "1kg, Priceg", "$4.99")
        )

        // Groceries
        val groceryList = listOf(
            Category(R.drawable.pulses, "Pulses", R.color.pulses_bg),
            Category(R.drawable.rice, "Rice", R.color.rice_bg),
            Category(R.drawable.pulses, "Pulses 2", R.color.pulses_bg)
        )

        val meatList = listOf(
            Product(R.drawable.beefbone, "Beef Bone", "1kg, PriceG", "$4.99"),
            Product(R.drawable.broilerchicken, "Broiler Chicken", "1kg, PriceG", "$4.99"),
            // 스크롤 확인을 위해 데이터 추가
            Product(R.drawable.beefbone, "Beef Bone 2", "1kg, PriceG", "$4.99"),
            Product(R.drawable.broilerchicken, "Broiler Chicken 2", "1kg, PriceG", "$4.99")
        )

        //5. 어댑터에 데이터 리스트 제출하기
        //어댑터는 이 리시트를 받아서, item_product.xml에 넣어 카드 모양으로 만든뒤 화면에 띄움
        exclusiveOfferAdapter.submitList(exclusiveOfferList)
        bestSellingAdapter.submitList(bestSellingList)
        groceryAdapter.submitList(groceryList)
        meatAdapter.submitList(meatList)
    }
}