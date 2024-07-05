package com.anddev404.show_habits.presentation.edit_top_bar

sealed class EditTopBarEvent {
    data object OnBackClick : EditTopBarEvent()
    data class OnEditClick(val id: Int) : EditTopBarEvent()
    data class OnChangeColorClick(val ids: List<Int>, val color: Int) : EditTopBarEvent()
    data class OnArchiveClick(val ids: List<Int>) : EditTopBarEvent()
    data class OnDeleteClick(val ids: List<Int>) : EditTopBarEvent()
}