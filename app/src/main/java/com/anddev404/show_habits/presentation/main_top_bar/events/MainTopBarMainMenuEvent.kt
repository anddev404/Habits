package com.anddev404.show_habits.components.main_top_bar.events

sealed class MainTopBarMainMenuEvent {
    data class OnToggleNightModeClick(val darkMode: Boolean) : MainTopBarMainMenuEvent()
    data object OnSettingsClick : MainTopBarMainMenuEvent()
    data object OnSupportClick : MainTopBarMainMenuEvent()
    data object OnAboutClick : MainTopBarMainMenuEvent()
    data object OnCloseClick : MainTopBarMainMenuEvent()

}