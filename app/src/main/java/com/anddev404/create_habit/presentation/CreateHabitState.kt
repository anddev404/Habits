package com.anddev404.create_habit.presentation

sealed class CreateHabitState {
    data object HabitLoading : CreateHabitState()
    data object HabitEditing : CreateHabitState()
    data object HabitDoesNotExist : CreateHabitState()
    data object HabitCreating : CreateHabitState()
}