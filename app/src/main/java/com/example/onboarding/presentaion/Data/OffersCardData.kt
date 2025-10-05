package com.example.onboarding.presentaion.Data

import com.example.onboarding.R

data class OffersCardModel(
    val title: String,
    val imageRes: Int)
object OffersCardData {

    val cardsList = listOf(
        OffersCardModel("مطاعم",R.drawable.ic_restaurants),
        OffersCardModel("الأزياء",R.drawable.ic_fashion),
        OffersCardModel("الإلكترونيات",R.drawable.ic_electronics),
        OffersCardModel("جمال",R.drawable.ic_beauty),
        OffersCardModel("عطور",R.drawable.ic_perfume_fragrance),
        OffersCardModel("سيارات",R.drawable.ic_cars),
        OffersCardModel("صيدليات",R.drawable.ic_pharmacy),
        OffersCardModel("مجوهرات",R.drawable.ic_jewelry),



        )}