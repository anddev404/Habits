package com.anddev404.create_habit.presentation.yes_or_no_content

enum class YesOrNoFrequencyState(
    var frequency: Int = -1,
    var startText: String = "",
    var endText: String = ""
) {
    DAILY(-1),
    INTERVAL(3),
    WEEKLY(3),
    MONTHLY(10);
}