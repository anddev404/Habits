package com.anddev404.show_habits.presentation.habits_view.items

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
import com.anddev404.show_habits.presentation.habits_view.states.HabitsViewItemState
import com.anddev404.ui.theme.LocalSpacing

@Composable
fun HabitsValueItem(
    state: HabitsViewItemState.Value, onClick: (HabitsViewItemState.Value) -> Unit = {}
) {

    Column(
        Modifier
            .size(LocalSpacing.current.habitItemSize)
            .clickable { onClick(state) },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy((-4).dp, alignment = Alignment.CenterVertically)
    ) {
        Text(
            color = state.color,
            modifier = Modifier.padding(0.dp),
            text = state.value.formatNumber(),
            maxLines = 1,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            color = state.color, text = state.unit, fontSize = 12.sp, maxLines = 1
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
    HabitsValueItem(
        HabitsViewItemState.Value(
            1,
            unit = "km",
            value = 10,
            color = Color.Blue
        )
    ) {
        Log.d(tag, "clicked: value=${it.value}  id=${it.id}")
    }
}

@Preview(showBackground = true)
@Composable
private fun HabitsValueItemPreview2() {
    val tag = "HabitsView"
    HabitsValueItem(
        HabitsViewItemState.Value(
            1,
            unit = "km"
        )
    ) {
        Log.d(tag, "clicked: value=${it.value}  id=${it.id}")
    }

}