package com.anddev404.create_habit.domain

data class CreateHabitUseCases(
    val insertHabit: InsertHabit,
    val getHabit: GetHabit
)