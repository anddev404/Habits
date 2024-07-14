package com.anddev404.core.data.repository

import com.anddev404.core.data.local.HabitDatabase
import com.anddev404.core.data.local.entity.HabitEntity
import com.anddev404.core.domain.repository.HabitRepository
import kotlinx.coroutines.flow.Flow

class HabitRepositoryImpl(private val database: HabitDatabase) : HabitRepository {

    override fun getHabitById(id: Int): Flow<HabitEntity?> {
        return database.habitDao().getHabitById(id)
    }

    override fun getAllHabits(): Flow<List<HabitEntity>> {
        return database.habitDao().getAll()
    }

    override suspend fun insertHabit(habit: HabitEntity) {
        database.habitDao().insert(habit)
    }

    override suspend fun updateHabit(habit: HabitEntity) {
        database.habitDao().update(habit)
    }

    override suspend fun deleteHabit(habit: HabitEntity) {
        database.habitDao().delete(habit)
    }
}