package com.anddev404.core.data.mapper

import androidx.compose.ui.text.input.TextFieldValue
import com.anddev404.core.data.local.entity.HabitEntity
import com.anddev404.show_habits.domain.model.Habit

fun HabitEntity.toHabit(): Habit {
    return Habit(
        TextFieldValue(name),
        true,
        TextFieldValue(notes),
        color,
        isArchived,
        position,
        reminder,
        habitType,
        frequencyNumerator,
        frequencyDenominator,
        unit,
        target,
        targetType,
        id
    )
}