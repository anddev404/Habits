package com.anddev404.show_habits.presentation.habits_view.states

import androidx.compose.ui.graphics.Color
import com.anddev404.ui.theme.InactiveDarkColor

sealed class HabitsViewItemState() {
    data class YesOrNo(
        var id: Int = 0,
        var habitId: Int = 0,
        var isChecked: Boolean = false,
        var color: Color = InactiveDarkColor,
        var date: Long = 0
    ) :
        HabitsViewItemState()

    data class Value(
        var id: Int = 0,
        var habitId: Int = 0,
        var unit: String = "",
        var value: Double = 0.0,
        var color: Color = InactiveDarkColor,
        var date: Long = 0
    ) : HabitsViewItemState()
}