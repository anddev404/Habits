package com.anddev404.create_habit.presentation.measurable_content

sealed class MeasurableFrequencyState() {
    data object DailyYesOrNoFrequency : MeasurableFrequencyState()
    data object WeeklyYesOrNoFrequency : MeasurableFrequencyState()
    data object MonthlyYesOrNoFrequency : MeasurableFrequencyState()
}