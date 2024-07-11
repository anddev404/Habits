package com.anddev404.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HabitEntity(
    val name: String,
    val notes: String,
    val color: Int,
    val isArchived: Boolean,
    val position: Boolean,
    val reminder: Long,
    val habitType: Int,
    val frequencyNumerator: Int,
    val frequencyDenominator: Int,
    val unit: String,
    val target: Double,
    val targetType: Int,
    @PrimaryKey val id: Int? = null
)