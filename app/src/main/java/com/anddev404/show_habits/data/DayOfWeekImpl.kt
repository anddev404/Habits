package com.anddev404.show_habits.data

import android.content.Context
import com.anddev404.R
import com.anddev404.show_habits.domain.model.DayOfWeek

class DayOfWeekImpl(private val context: Context) : DayOfWeek {

    override fun getDayOfWeek(numberOfDay: Int): String {
        return when (numberOfDay) {
            1 -> context.getString(R.string.monday)
            2 -> context.getString(R.string.tuesday)
            3 -> context.getString(R.string.wednesday)
            4 -> context.getString(R.string.thursday)
            5 -> context.getString(R.string.friday)
            6 -> context.getString(R.string.saturday)
            7 -> context.getString(R.string.sunday)
            else -> "n.d."
        }
    }
}