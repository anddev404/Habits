package com.anddev404.create_habit.presentation.yes_or_no_content

import android.content.Context
import com.anddev404.R

enum class YesOrNoFrequencyState(
    var frequency: Int = -1
) {
    DAILY(-1),
    INTERVAL(3),
    WEEKLY(3),
    MONTHLY(10);

    private fun getStartText(context: Context): String {
        return when (this) {
            DAILY -> context.getString(R.string.daily)
            INTERVAL -> context.getString(R.string.interval_start_text)
            WEEKLY -> ""
            MONTHLY -> ""
        }
    }

    private fun getEndText(context: Context): String {
        return when (this) {
            DAILY -> ""
            INTERVAL -> context.getString(R.string.interval_end_text)
            WEEKLY -> context.getString(R.string.weekly)
            MONTHLY -> context.getString(R.string.monthly)
        }
    }

    fun toString(context: Context): String {
        val frequency: String = if (frequency > 0) frequency.toString() else ""

        return "${getStartText(context)} $frequency ${getEndText(context)}".trim()
    }
}