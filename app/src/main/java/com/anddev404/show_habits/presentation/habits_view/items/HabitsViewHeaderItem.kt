package com.anddev404.show_habits.presentation.habits_view.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anddev404.show_habits.presentation.habits_view.states.HabitsViewHeaderItemState
import com.anddev404.ui.theme.LocalSpacing
import com.anddev404.ui.theme.TextColor


@Composable
fun HabitsViewHeaderItem(
    state: HabitsViewHeaderItemState
) {
    Column(
        Modifier
            .size(LocalSpacing.current.habitItemSize),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy((-4).dp, alignment = Alignment.CenterVertically)
    ) {
        Text(
            color = TextColor,
            modifier = Modifier.padding(0.dp),
            text = state.dayOfWeek,
            maxLines = 1,
            fontSize = LocalSpacing.current.fontSizeMedium,
            fontWeight = FontWeight.Bold,
        )
        Text(
            color = TextColor,
            text = state.dayOfMonth.toString(),
            fontSize = LocalSpacing.current.fontSizeMediumSmall,
            maxLines = 1,
            fontWeight = FontWeight.Bold,
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun HabitsValueItemPreview1() {
    Row {
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfWeek = "Mon", dayOfMonth = 1))
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfWeek = "Tue", dayOfMonth = 2))
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfWeek = "Wed", dayOfMonth = 3))
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfWeek = "Thu", dayOfMonth = 4))
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfWeek = "Fri", dayOfMonth = 5))
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfWeek = "Sat", dayOfMonth = 6))
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfWeek = "Sun", dayOfMonth = 7))
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfWeek = "Mon", dayOfMonth = 8))
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfWeek = "Tue", dayOfMonth = 9))
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfWeek = "Wed", dayOfMonth = 10))
    }
}