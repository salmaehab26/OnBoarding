package com.example.onboarding.presentaion.Data

import android.graphics.Color
import com.example.onboarding.R

data class CardModel(
    val subtitle: String,
    val imageRes: Int,
    val startColor: Int,
    val endColor: Int
)
object CardData{

    val cardsList=listOf(
        CardModel("الذكاء العاطفي", R.drawable.illu_assessment_emotional_intelligence,
            Color.parseColor("#D7CEFD"), Color.parseColor("#8A80DB")),


        CardModel("القلق", R.drawable.illu_assessment_work_stress,
            Color.parseColor("#F2C9A5"), Color.parseColor("#FD9438")),
        CardModel("الصحة النفسيه العامه", R.drawable.illu_assessment_general_mental_health,
            Color.parseColor("#BCDD8A"), Color.parseColor("#6CBC6F")),

        CardModel("الرضا عن الحياة", R.drawable.illu_assessment_life_satisfaction,
            Color.parseColor("#D7CEFD"), Color.parseColor("#8A80DB")),
        CardModel("الاكتئاب", R.drawable.illu_assessment_depression,
            Color.parseColor("#F2C9A5"), Color.parseColor("#FD9438")),
        CardModel("جهازية المدير", R.drawable.illu_assessment_manager_readiness,
            Color.parseColor("#BCDD8A"), Color.parseColor("#6CBC6F")),
        CardModel("الرفاهية النفسيه", R.drawable.illu_assessment_psychological_well_being,
            Color.parseColor("#D7CEFD"), Color.parseColor("#8A80DB")),
        CardModel("الوسواس القهري", R.drawable.illu_assessment_ocd,
            Color.parseColor("#F2C9A5"), Color.parseColor("#FD9438")),
    )
}