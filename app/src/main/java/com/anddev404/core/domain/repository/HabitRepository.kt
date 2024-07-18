package com.anddev404.core.domain.repository

import androidx.room.Query
import com.anddev404.core.data.local.entity.HabitEntity
import com.anddev404.core.data.local.entity.ItemEntity
import kotlinx.coroutines.flow.Flow

interface HabitRepository {
    fun getItemsAfterDate(date: Long): Flow<List<ItemEntity>>

    suspend fun insertItem(item: ItemEntity)

    suspend fun getHabitById(id: Int): HabitEntity?

    fun getAllHabits(): Flow<List<HabitEntity>>

    suspend fun insertHabit(habit: HabitEntity)

    suspend fun updateHabit(habit: HabitEntity)

    suspend fun deleteHabit(habit: HabitEntity)
}