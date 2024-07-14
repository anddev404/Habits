package com.anddev404.core.domain.repository

import androidx.room.Query
import com.anddev404.core.data.local.entity.HabitEntity
import kotlinx.coroutines.flow.Flow

interface HabitRepository {

    fun getHabitById(id: Int): Flow<HabitEntity?>

    fun getAllHabits(): Flow<List<HabitEntity>>

    suspend fun insertHabit(habit: HabitEntity)

    suspend fun updateHabit(habit: HabitEntity)

    suspend fun deleteHabit(habit: HabitEntity)
}