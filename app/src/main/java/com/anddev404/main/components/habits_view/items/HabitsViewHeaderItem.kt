package com.anddev404.main.components.habits_view.items

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
import com.anddev404.main.components.habits_view.states.HabitsViewHeaderItemState
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
            text = state.dayOfTheWeek,
            maxLines = 1,
            fontSize = LocalSpacing.current.fontSizeMedium,
            fontWeight = FontWeight.Bold,
        )
        Text(
            color = TextColor,
            text = state.dayOfTheMonth.toString(),
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
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfTheWeek = "Mon", dayOfTheMonth = 1))
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfTheWeek = "Tue", dayOfTheMonth = 2))
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfTheWeek = "Wed", dayOfTheMonth = 3))
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfTheWeek = "Thu", dayOfTheMonth = 4))
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfTheWeek = "Fri", dayOfTheMonth = 5))
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfTheWeek = "Sat", dayOfTheMonth = 6))
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfTheWeek = "Sun", dayOfTheMonth = 7))
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfTheWeek = "Mon", dayOfTheMonth = 8))
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfTheWeek = "Tue", dayOfTheMonth = 9))
        HabitsViewHeaderItem(HabitsViewHeaderItemState(dayOfTheWeek = "Wed", dayOfTheMonth = 10))
    }
}