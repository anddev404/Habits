package com.anddev404.habits.components.main_top_bar.events

sealed class MainTopBarFilterMenuEvent {
    data class OnToggleHideArchived(val hideArchived: Boolean) : MainTopBarFilterMenuEvent()
    data class OnToggleHideCompleted(val hideCompleted: Boolean) : MainTopBarFilterMenuEvent()
    data object OnSortClick : MainTopBarFilterMenuEvent()
    data object OnExitClick : MainTopBarFilterMenuEvent()

}