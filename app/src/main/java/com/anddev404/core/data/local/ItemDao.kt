package com.anddev404.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anddev404.core.data.local.entity.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ItemEntity)

    @Query("SELECT * FROM ItemEntity WHERE date >= :date")
    fun getItemsAfterDate(date: Long): Flow<List<ItemEntity>>
}