package com.anddev404.main.components

sealed class MainTopBarSortMenuEvent {
    data object OnManuallyClick : MainTopBarSortMenuEvent()
    data object OnByNameClick : MainTopBarSortMenuEvent()
    data object OnByColorClick : MainTopBarSortMenuEvent()
    data object OnByResultClick : MainTopBarSortMenuEvent()
    data object OnByStatusClick : MainTopBarSortMenuEvent()
    data object OnDismissClick : MainTopBarSortMenuEvent()
}