package com.anddev404.main.components.main_top_bar.events

sealed class MainTopBarSortMenuEvent {
    data object OnManuallyClick : MainTopBarSortMenuEvent()
    data object OnByNameClick : MainTopBarSortMenuEvent()
    data object OnByColorClick : MainTopBarSortMenuEvent()
    data object OnByResultClick : MainTopBarSortMenuEvent()
    data object OnByStatusClick : MainTopBarSortMenuEvent()
    data object OnDismissClick : MainTopBarSortMenuEvent()
}