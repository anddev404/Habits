package com.anddev404.show_habits.presentation.habits_view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anddev404.show_habits.presentation.habits_view.events.HabitsViewRowEvent
import com.anddev404.show_habits.presentation.habits_view.states.HabitsViewHeaderItemState
import com.anddev404.show_habits.presentation.habits_view.states.HabitsViewItemState
import com.anddev404.show_habits.presentation.habits_view.states.HabitsViewRowState
import com.anddev404.ui.theme.BackgroundColor
import kotlin.random.Random

@Composable
fun HabitsView(
    modifier: Modifier = Modifier,
    headerState: List<HabitsViewHeaderItemState> = listOf(),
    habitsStates: List<HabitsViewRowState> = listOf(),
    events: (HabitsViewRowEvent) -> Unit = {}
) {
    Column(
        modifier
            .background(BackgroundColor)
            .padding(2.dp)
    ) {

        var firstVisibleItemIndex by remember { mutableIntStateOf(0) }
        var firstVisibleItemScrollOffset by remember { mutableIntStateOf(0) }

        HabitsViewHeader(headerState) {
            firstVisibleItemIndex = it.firstVisibleItemIndex
            firstVisibleItemScrollOffset = it.firstVisibleItemScrollOffset
        }

        LazyColumn {
            itemsIndexed(habitsStates) { _, habitsState ->
                HabitsViewRow(
                    lazyListState = LazyListState(
                        firstVisibleItemIndex,
                        firstVisibleItemScrollOffset
                    ),
                    state = habitsState
                ) {
                    events(it)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HabitsViewPreview() {
    HabitsView(
        headerState = getHeaderList(),
        habitsStates = getNewRowState()
    ) {
        val tag = "HabitsView"
        when (it) {
            is HabitsViewRowEvent.OnItemClick -> {
                when (it.item) {
                    is HabitsViewItemState.Value -> {
                        Log.d(
                            tag, "clicked: value=${it.item.value}  id=${it.item.id}"
                        )
                    }

                    is HabitsViewItemState.YesOrNo -> {
                        Log.d(
                            tag, "clicked: isChecked=${it.item.isChecked}  id=${it.item.id}"
                        )
                    }
                }
            }

            is HabitsViewRowEvent.OnRowClick -> Log.d(
                tag, "Row clicked: ${it.row.rowId}"
            )

            is HabitsViewRowEvent.OnRowLongClick -> {}
        }
    }
}

private fun getHeaderList(): List<HabitsViewHeaderItemState> = listOf(
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
    HabitsViewHeaderItemState(dayOfWeek = "Sun", dayOfMonth = 14)
).reversed()

private fun getNewRowState(): List<HabitsViewRowState> {

    val list = arrayListOf<HabitsViewRowState>()

    for (i in 1..15) {
        val id = Random.nextInt(100)
        val color = getRandomColor()

        list.add(
            HabitsViewRowState(
                id,
                "Habit # $id",
                Random.nextFloat(),
                getHabitItemStates(color),
                color = color
            )
        )
    }
    return list
}

private fun getHabitItemStates(color: Color): List<HabitsViewItemState.YesOrNo> {
    val list = arrayListOf<HabitsViewItemState.YesOrNo>()
    for (i in 1..15) {
        list.add(HabitsViewItemState.YesOrNo(i, 0, Random.nextBoolean(), color, 0))
    }
    return list
}

private fun getRandomColor(): Color {
    val r = Random.nextInt(0, 256)
    val g = Random.nextInt(0, 256)
    val b = Random.nextInt(0, 256)
    return Color(r, g, b)
}

