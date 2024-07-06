package com.anddev404.show_habits.presentation.habits_view

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anddev404.show_habits.presentation.habits_view.items.HabitsViewHeaderItem
import com.anddev404.show_habits.presentation.habits_view.states.HabitsViewHeaderItemState

@Composable
fun HabitsViewHeader(
    state: List<HabitsViewHeaderItemState> = listOf(),
    lazyListState: (LazyListState) -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
    ) {
        val rowWeight: Float
        val lazyRowWeight: Float

        if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT) {
            rowWeight = 0.5f
            lazyRowWeight = 0.5f
        } else {
            rowWeight = 0.3f
            lazyRowWeight = 0.7f
        }

        Row(
            modifier = Modifier.weight(rowWeight),
        ) {}

        val listState = rememberLazyListState()
        lazyListState(listState)

        LazyRow(
            state = listState, modifier = Modifier.weight(lazyRowWeight)
        ) {
            itemsIndexed(state) { _, item ->
                HabitsViewHeaderItem(item)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HabitsViewHeaderPreview() {
    val list: List<HabitsViewHeaderItemState> = listOf(
        HabitsViewHeaderItemState(dayOfTheWeek = "Mon", dayOfTheMonth = 1),
        HabitsViewHeaderItemState(dayOfTheWeek = "Tue", dayOfTheMonth = 2),
        HabitsViewHeaderItemState(dayOfTheWeek = "Wed", dayOfTheMonth = 3),
        HabitsViewHeaderItemState(dayOfTheWeek = "Thu", dayOfTheMonth = 4),
        HabitsViewHeaderItemState(dayOfTheWeek = "Fri", dayOfTheMonth = 5),
        HabitsViewHeaderItemState(dayOfTheWeek = "Sat", dayOfTheMonth = 6),
        HabitsViewHeaderItemState(dayOfTheWeek = "Sun", dayOfTheMonth = 7),
        HabitsViewHeaderItemState(dayOfTheWeek = "Mon", dayOfTheMonth = 8),
        HabitsViewHeaderItemState(dayOfTheWeek = "Tue", dayOfTheMonth = 9),
        HabitsViewHeaderItemState(dayOfTheWeek = "Wed", dayOfTheMonth = 10),
        HabitsViewHeaderItemState(dayOfTheWeek = "Thu", dayOfTheMonth = 11),
        HabitsViewHeaderItemState(dayOfTheWeek = "Fri", dayOfTheMonth = 12),
        HabitsViewHeaderItemState(dayOfTheWeek = "Sat", dayOfTheMonth = 13),
        HabitsViewHeaderItemState(dayOfTheWeek = "Sun", dayOfTheMonth = 14),
    )
    HabitsViewHeader(list) {
        Log.d(
            "HabitsView",
            "position  ${it.firstVisibleItemIndex}   ${it.firstVisibleItemScrollOffset}"
        )
    }
}

