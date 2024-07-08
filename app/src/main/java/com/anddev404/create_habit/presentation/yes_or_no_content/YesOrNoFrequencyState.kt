package com.anddev404.create_habit.presentation.yes_or_no_content

sealed class YesOrNoFrequencyState() {
    data object DailyYesOrNoFrequency : YesOrNoFrequencyState()
    data class IntervalYesOrNoFrequency(val frequency: Int) : YesOrNoFrequencyState()
    data class WeeklyYesOrNoFrequency(val frequency: Int) : YesOrNoFrequencyState()
    data class MonthlyYesOrNoFrequency(val frequency: Int) : YesOrNoFrequencyState()
}