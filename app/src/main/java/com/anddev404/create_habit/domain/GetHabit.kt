package com.anddev404.create_habit.domain

import com.anddev404.core.data.local.entity.HabitEntity
import com.anddev404.core.domain.repository.HabitRepository

class GetHabit(private val repository: HabitRepository) {
    suspend operator fun invoke(id: Int): Result<HabitEntity> {
        repository.getHabitById(id)?.let {
            return@invoke Result.success(it)
        }
        return Result.failure(Throwable())
    }
}
