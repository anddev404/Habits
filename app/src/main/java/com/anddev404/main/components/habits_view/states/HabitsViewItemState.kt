package com.anddev404.main.components.habits_view.states

import androidx.compose.ui.graphics.Color
import com.anddev404.ui.theme.InactiveDarkColor

sealed class HabitsViewItemState() {
    data class YesOrNo(
        val id: Int,
        var isChecked: Boolean = false,
        val color: Color = InactiveDarkColor
    ) :
        HabitsViewItemState()

    data class Value(
        val id: Int, var unit: String, var value: Int = 0, var color: Color = InactiveDarkColor
    ) : HabitsViewItemState()
}