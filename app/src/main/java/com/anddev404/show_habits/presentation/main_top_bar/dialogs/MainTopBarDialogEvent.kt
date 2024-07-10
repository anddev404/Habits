package com.anddev404.show_habits.presentation.main_top_bar.dialogs

sealed class MainTopBarDialogEvent {
    data object OnAddHabitYesOrNoClick : MainTopBarDialogEvent()
    data object OnAddHabitMeasurableClick : MainTopBarDialogEvent()
}