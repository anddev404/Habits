package com.anddev404.show_habits.components.habits_view

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
import com.anddev404.show_habits.components.habits_view.events.HabitsViewRowEvent
import com.anddev404.show_habits.components.habits_view.states.HabitsViewHeaderItemState
import com.anddev404.show_habits.components.habits_view.states.HabitsViewItemState
import com.anddev404.show_habits.components.habits_view.states.HabitsViewRowState
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
                    LazyListState(firstVisibleItemIndex, firstVisibleItemScrollOffset),
                    habitsState
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
        list.add(HabitsViewItemState.YesOrNo(i, Random.nextBoolean(), color))
    }
    return list
}

private fun getRandomColor(): Color {
    val r = Random.nextInt(0, 256)
    val g = Random.nextInt(0, 256)
    val b = Random.nextInt(0, 256)
    return Color(r, g, b)
}

