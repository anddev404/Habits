package com.anddev404.create_habit.domain.use_case

import com.anddev404.core.data.local.entity.HabitEntity
import com.anddev404.core.domain.repository.HabitRepository

class InsertHabit(private val repository: HabitRepository) {

    suspend operator fun invoke(habit: HabitEntity) {
        repository.insertHabit(habit)
    }
}