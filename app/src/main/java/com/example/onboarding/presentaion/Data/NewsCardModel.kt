package com.example.onboarding.presentaion.Data

import com.example.onboarding.R

data class NewsCardModel(
    val title: String,
    val imageRes: Int,
)

object NewsCardData {

    val cardsList = listOf(
        NewsCardModel(" ...كيف استفيد من برنامج أمجاد", R.drawable.offer_image),
        NewsCardModel("...أمجاد وطن تشارك في معرض", R.drawable.offer_image2),
        NewsCardModel("...كيف استفيد من برنامج أمجاد", R.drawable.offer_image3),
        NewsCardModel("...أمجاد وطن تشارك في معرض", R.drawable.offer_image),
    )
}