package com.anddev404.show_habits.presentation.edit_top_bar

sealed class EditTopBarMenuEvent {
    data object OnArchiveClick : EditTopBarMenuEvent()
    data object OnDeleteClick : EditTopBarMenuEvent()
    data object OnDismiss : EditTopBarMenuEvent()
}