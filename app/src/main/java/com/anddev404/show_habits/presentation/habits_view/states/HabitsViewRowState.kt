package com.anddev404.show_habits.components.habits_view.states

import androidx.compose.ui.graphics.Color

data class HabitsViewRowState(
    val rowId: Int = 0,
    val name: String = "",
    val progress: Float = 0f,
    val itemList: List<HabitsViewItemState> = arrayListOf(),
    val color: Color = Color.Unspecified
)
