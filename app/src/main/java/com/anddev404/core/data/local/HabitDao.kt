package com.anddev404.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anddev404.core.data.local.entity.HabitEntity

@Dao
interface HabitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(habit: HabitEntity)

    @Query("SELECT * FROM HabitEntity")
    suspend fun getAll(): List<HabitEntity>
}