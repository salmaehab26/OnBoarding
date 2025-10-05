package com.example.onboarding.presentaion.Data

import android.graphics.Color
import com.example.onboarding.R

data class BoxesDataModel(
    val subtitle: String,
    val Color: Int,
)

object BoxesCardData {

    val BoxesCardsList = listOf(
        BoxesDataModel(
            "سجل حضوري",
            Color.parseColor("#F5A158")
        ),
        BoxesDataModel(
            "اعتماداتي",
            Color.parseColor("#E7636F")
        ),
        BoxesDataModel(
            "إجازاتي",
            Color.parseColor("#679CC8")
        ),
        BoxesDataModel(
            "عمل عن بعد",
            Color.parseColor("#5CBC6C")
        ),
        BoxesDataModel(
            "مستنداتي",
            Color.parseColor("#7961AC")
        ),
        BoxesDataModel(
            "عُهداتي",
            Color.parseColor("#ABB9C2")
        ),
        BoxesDataModel(
            "أذناتي",
            Color.parseColor("#7BAEAE")
        ),
        BoxesDataModel(
            "نسمعك",
            Color.parseColor("#BF755A")
        ),
        BoxesDataModel(
            "سجل حضوري",
            Color.parseColor("#F5A158")
        ),
        BoxesDataModel(
            "اعتماداتي",
            Color.parseColor("#E7636F")
        ),
        BoxesDataModel(
            "إجازاتي",
            Color.parseColor("#679CC8")
        ),
        BoxesDataModel(
            "عمل عن بعد",
            Color.parseColor("#5CBC6C")
        ),


        )
}