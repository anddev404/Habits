package com.anddev404.main.components.habits_view.events

import com.anddev404.main.components.habits_view.states.HabitsViewItemState
import com.anddev404.main.components.habits_view.states.HabitsViewRowState

sealed class HabitsViewRowEvent {
    data class OnItemClick(val item: HabitsViewItemState) : HabitsViewRowEvent()
    data class OnRowClick(val row: HabitsViewRowState) : HabitsViewRowEvent()
    data class OnRowLongClick(val row: HabitsViewRowState) : HabitsViewRowEvent()
}