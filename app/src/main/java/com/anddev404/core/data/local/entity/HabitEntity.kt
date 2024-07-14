package com.anddev404.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HabitEntity(
    val name: String = "",
    val notes: String = "",
    val color: Int = 0,
    val isArchived: Boolean = false,
    val position: Int = 0,
    val reminder: Long = 0,
    val habitType: Int = 0,
    val frequencyNumerator: Int = 0,
    val frequencyDenominator: Int = 0,
    val unit: String = "",
    val target: Double = 0.0,
    val targetType: Int = 0,
    @PrimaryKey val id: Int? = null
)