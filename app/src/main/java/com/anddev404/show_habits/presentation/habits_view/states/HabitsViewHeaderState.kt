package com.anddev404.show_habits.presentation.habits_view.states

import java.util.Calendar

data class HabitsViewHeaderItemState(
    val dayOfWeek: String = "",
    val dayOfMonth: Int = 0,
    val month: Int = 0,
    val year: Int = 0
) {
    fun getTimeInMilliseconds(): Long {
        val calendar = Calendar.getInstance()
        calendar.set(year, month - 1, dayOfMonth, 0, 0, 0)
        calendar.set(Calendar.MILLISECOND, 0)

        return calendar.timeInMillis
    }
}

