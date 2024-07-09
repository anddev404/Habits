package com.anddev404.create_habit.presentation.yes_or_no_content

import android.content.Context
import com.anddev404.R

enum class YesOrNoFrequencyState(
    var frequency: Int = -1,
    var startText: String = "",
    var endText: String = ""
) {
    DAILY(-1),
    INTERVAL(3),
    WEEKLY(3),
    MONTHLY(10);

    fun toString(context: Context): String {
        val frequency: String = if (frequency > 0) frequency.toString() else ""

        when (this) {
            DAILY -> startText = context.getString(R.string.daily)
            INTERVAL -> {
                startText = context.getString(R.string.interval_start_text)
                endText = context.getString(R.string.interval_end_text)
            }

            WEEKLY -> endText = context.getString(R.string.weekly)
            MONTHLY -> endText = context.getString(R.string.monthly)
        }
        return "${startText} $frequency ${endText}".trim()
    }
}