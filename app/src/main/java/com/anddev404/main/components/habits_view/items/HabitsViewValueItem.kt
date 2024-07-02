package com.anddev404.main.components.habits_view.items

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anddev404.ui.theme.InactiveLightColor
import com.anddev404.ui.theme.LocalSpacing

@Composable
fun HabitsValueItem(
    textColor: Color = InactiveLightColor,
    value: Int = 0,
    unit: String,
    onClick: (Int) -> Unit = {}
) {

    Column(
        Modifier
            .size(LocalSpacing.current.habitItemSize)
            .clickable { onClick(value) },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy((-4).dp, alignment = Alignment.CenterVertically)
    ) {
        Text(
            color = textColor,
            modifier = Modifier.padding(0.dp),
            text = value.formatNumber(),
            maxLines = 1,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            color = textColor,
            text = unit,
            fontSize = 12.sp,
            maxLines = 1
        )
    }
}

fun Int.formatNumber(): String {
    return when {
        this >= 1_000_000 -> String.format("%.1fM", this / 1_000_000.0)
        this >= 10_000 -> String.format("%dk", this / 1_000)
        this >= 1_000 -> String.format("%.1fk", this / 1_000.0)
        else -> this.toString()
    }
}

@Preview(showBackground = true)
@Composable
private fun HabitsValueItemPreview1() {
    val tag = "HabitsView"
    HabitsValueItem(unit = "km", value = 10, textColor = Color.Blue) {
        Log.d(tag, "clicked: $it")
    }

}

@Preview(showBackground = true)
@Composable
private fun HabitsValueItemPreview2() {
    val tag = "HabitsView"
    HabitsValueItem(unit = "km") {
        Log.d(tag, "clicked: $it")
    }

}