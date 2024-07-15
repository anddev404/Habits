package com.anddev404.show_habits.domain.model

import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.input.TextFieldValue
import com.anddev404.core.presentation.components.defaultPaletteColor

data class Habit(
    var name: TextFieldValue = TextFieldValue(),
    var isValidName: Boolean = true,
    val notes: TextFieldValue = TextFieldValue(),
    val color: Int = defaultPaletteColor.toArgb(),
    val isArchived: Boolean = false,
    val position: Int = 0,
    val reminder: Long = 0,
    val habitType: Int = 0,
    val frequencyNumerator: Int = 0,
    val frequencyDenominator: Int = 0,
    val unit: String = "",
    val target: Double = 0.0,
    val targetType: Int = 0,
    val id: Int? = null
) {
}