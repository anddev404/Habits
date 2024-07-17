package com.anddev404.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemEntity(
    val date: Long,
    val isChecked: Boolean,
    val value: Double,
    val habitId: Int,
    @PrimaryKey(true)
    val id: Int = 0
)