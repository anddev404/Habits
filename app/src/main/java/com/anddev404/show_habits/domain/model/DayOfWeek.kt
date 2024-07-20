package com.anddev404.show_habits.domain.model

enum class DayOfWeek(val dayNumber: Int) {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7),
    UNKNOWN(0);

    companion object {
        fun fromInt(value: Int): DayOfWeek {
            return values().find { it.dayNumber == value } ?: UNKNOWN
        }
    }
}