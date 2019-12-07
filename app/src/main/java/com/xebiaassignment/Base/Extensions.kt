package com.xebiaassignment.Base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

fun navigateToNextActivity(activity: AppCompatActivity, intent: Intent, finishActivity: Boolean) {
    activity.startActivity(intent)
    if (finishActivity) {
        activity.finish()
    }
}