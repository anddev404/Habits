package com.anddev404.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Dimensions(
    val default: Dp = 0.dp,
    val spaceExtraSmall: Dp = 4.dp,
    val spaceSmall: Dp = 8.dp,
    val spaceMediumSmall: Dp = 12.dp,
    val spaceMedium: Dp = 16.dp,
    val spaceLarge: Dp = 32.dp,
    val spaceExtraLarge: Dp = 64.dp,

    val habitItemSize: Dp = 48.dp,
    val habitItemSizeSmall: Dp = 40.dp,

    val fontSizeMediumSmall: TextUnit = 12.sp,
    val fontSizeMedium: TextUnit = 16.sp,
    val fontSizeLarge: TextUnit = 20.sp,
)

val LocalSpacing = compositionLocalOf { Dimensions() }
