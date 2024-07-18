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
        HabitsViewHeaderItemState(dayOfWeek = "Mon", dayOfMonth = 1),
        HabitsViewHeaderItemState(dayOfWeek = "Tue", dayOfMonth = 2),
        HabitsViewHeaderItemState(dayOfWeek = "Wed", dayOfMonth = 3),
        HabitsViewHeaderItemState(dayOfWeek = "Thu", dayOfMonth = 4),
        HabitsViewHeaderItemState(dayOfWeek = "Fri", dayOfMonth = 5),
        HabitsViewHeaderItemState(dayOfWeek = "Sat", dayOfMonth = 6),
        HabitsViewHeaderItemState(dayOfWeek = "Sun", dayOfMonth = 7),
        HabitsViewHeaderItemState(dayOfWeek = "Mon", dayOfMonth = 8),
        HabitsViewHeaderItemState(dayOfWeek = "Tue", dayOfMonth = 9),
        HabitsViewHeaderItemState(dayOfWeek = "Wed", dayOfMonth = 10),
        HabitsViewHeaderItemState(dayOfWeek = "Thu", dayOfMonth = 11),
        HabitsViewHeaderItemState(dayOfWeek = "Fri", dayOfMonth = 12),
        HabitsViewHeaderItemState(dayOfWeek = "Sat", dayOfMonth = 13),
        HabitsViewHeaderItemState(dayOfWeek = "Sun", dayOfMonth = 14),

        )
    HabitsViewHeader(list) {
        Log.d(
            "HabitsView",
            "position  ${it.firstVisibleItemIndex}   ${it.firstVisibleItemScrollOffset}"
        )
    }
}

