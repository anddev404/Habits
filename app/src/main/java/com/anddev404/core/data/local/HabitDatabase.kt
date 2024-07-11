package com.anddev404.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anddev404.core.data.local.entity.HabitEntity


@Database(entities = [HabitEntity::class], version = 1)
abstract class HabitDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
}
