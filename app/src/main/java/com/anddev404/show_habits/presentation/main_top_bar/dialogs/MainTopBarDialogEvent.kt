package com.anddev404.show_habits.presentation.main_top_bar.dialogs


enum class MainTopBarDialogEvent(val contentId: Int) {
    OnAddHabitYesOrNoClick(1),
    OnAddHabitMeasurableClick(2);

    companion object {
        fun getByContentId(
            contentId: Int,
            default: MainTopBarDialogEvent = OnAddHabitYesOrNoClick
        ): MainTopBarDialogEvent {
            return MainTopBarDialogEvent.values().find { it.contentId == contentId } ?: default
        }
    }
}