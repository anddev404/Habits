package com.anddev404.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anddev404.core.data.local.entity.HabitEntity
import com.anddev404.core.data.local.entity.ItemEntity


@Database(entities = [HabitEntity::class, ItemEntity::class], version = 1)
abstract class HabitDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
    abstract fun itemDao(): ItemDao
}
