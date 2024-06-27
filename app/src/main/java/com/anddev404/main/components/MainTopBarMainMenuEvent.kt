package com.anddev404.main.components

sealed class MainTopBarMainMenuEvent {
    data class OnToggleNightModeClick(val darkMode: Boolean) : MainTopBarMainMenuEvent()
    data object OnSettingsClick : MainTopBarMainMenuEvent()
    data object OnSupportClick : MainTopBarMainMenuEvent()
    data object OnAboutClick : MainTopBarMainMenuEvent()
}