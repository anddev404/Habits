package com.anddev404.show_habits.domain

import com.anddev404.show_habits.domain.model.CustomDate
import java.time.LocalDate

object DateGenerator {

    fun getCustomDatesFromToday(numberOfDays: Int): List<CustomDate> {
        val datesList = mutableListOf<CustomDate>()

        val today = LocalDate.now()
        for (i in 0 until numberOfDays) {
            val date = today.minusDays(i.toLong())

            val year = date.year
            val month = date.monthValue
            val day = date.dayOfMonth
            val dayOfWeek = date.dayOfWeek.value.toString()

            datesList.add(CustomDate(year, month, day, dayOfWeek))
        }
        return datesList
    }
}