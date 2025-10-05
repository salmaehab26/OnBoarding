package com.example.onboarding.presentaion.Data

import android.content.Context

object SharedPrefrence {
    fun setNotificationsRead(context: Context, read: Boolean) {
        val sp = context.getSharedPreferences("sharedPreference", Context.MODE_PRIVATE)
        sp.edit().putBoolean("notifications_read", read).apply()
    }

    fun isNotificationsRead(context: Context): Boolean {
        val sp = context.getSharedPreferences("sharedPreference", Context.MODE_PRIVATE)
        return sp.getBoolean("notifications_read", false)
    }
}