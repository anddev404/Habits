package com.anddev404.show_habits.presentation.main_top_bar

import com.anddev404.show_habits.presentation.main_top_bar.dialogs.MainTopBarDialogEvent

sealed class MainTopBarEvents {
    data class OnAddHabitClick(val event: MainTopBarDialogEvent) : MainTopBarEvents()
}