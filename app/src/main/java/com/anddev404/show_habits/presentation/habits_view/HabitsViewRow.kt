package com.anddev404.show_habits.components.habits_view

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anddev404.R
import com.anddev404.show_habits.components.habits_view.events.HabitsViewRowEvent
import com.anddev404.show_habits.components.habits_view.items.HabitsValueItem
import com.anddev404.show_habits.components.habits_view.items.HabitsYesOrNoItem
import com.anddev404.show_habits.components.habits_view.states.HabitsViewItemState
import com.anddev404.show_habits.components.habits_view.states.HabitsViewRowState
import com.anddev404.ui.theme.BackgroundColor
import com.anddev404.ui.theme.InactiveDarkColor
import com.anddev404.ui.theme.InactiveLightColor
import com.anddev404.ui.theme.LocalSpacing

@Composable
fun HabitsViewRow(
    isChecked: Boolean = false,
    lazyListState: LazyListState = LazyListState(),
    state: HabitsViewRowState,
    event: (HabitsViewRowEvent) -> Unit = {}
) {
    Card(
        border = if (isChecked) BorderStroke(2.dp, color = InactiveDarkColor) else null,
        modifier = Modifier.padding(1.dp),
        colors = CardDefaults.cardColors(containerColor = if (isChecked) BackgroundColor else Color.White),
        shape = RoundedCornerShape(1.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    event(HabitsViewRowEvent.OnRowClick(state))
                }, onLongPress = {
                    event(HabitsViewRowEvent.OnRowLongClick(state))
                })
            }) {

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
            ) {

                Spacer(modifier = Modifier.width(LocalSpacing.current.spaceSmall))
                CircularProgressIndicator(
                    state.progress,
                    trackColor = InactiveLightColor,
                    color = state.color,
                    strokeWidth = 3.dp,
                    modifier = Modifier
                        .height(LocalSpacing.current.habitItemSize)
                        .wrapContentHeight(
                            align = Alignment.CenterVertically
                        )
                        .size(16.dp)
                )

                Spacer(modifier = Modifier.width(LocalSpacing.current.spaceSmall))
                Text(
                    text = state.name,
                    color = state.color,
                    textAlign = TextAlign.Left,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    fontSize = LocalSpacing.current.fontSizeMedium,
                    modifier = Modifier
                        .height(LocalSpacing.current.habitItemSize)
                        .fillMaxWidth()
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )
            }

            LazyRow(
                state = lazyListState,
                userScrollEnabled = false,
                modifier = Modifier.weight(lazyRowWeight)
            ) {
                itemsIndexed(state.itemList) { _, item ->
                    when (item) {
                        is HabitsViewItemState.Value -> HabitsValueItem(item) {
                            event(HabitsViewRowEvent.OnItemClick(it))
                        }

                        is HabitsViewItemState.YesOrNo -> HabitsYesOrNoItem(item) {
                            event(HabitsViewRowEvent.OnItemClick(it))
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HabitsViewRowPreview() {
    val yesOrNoList: List<HabitsViewItemState.YesOrNo> = listOf(
        HabitsViewItemState.YesOrNo(1, true, Color.Blue),
        HabitsViewItemState.YesOrNo(2, false, Color.Blue),
        HabitsViewItemState.YesOrNo(3, false, Color.Blue),
        HabitsViewItemState.YesOrNo(4, false, Color.Blue),
        HabitsViewItemState.YesOrNo(5, true, Color.Blue),
        HabitsViewItemState.YesOrNo(6, true, Color.Blue)
    )

    val valueList: List<HabitsViewItemState.Value> = listOf(
        HabitsViewItemState.Value(1, "km", color = Color.Red),
        HabitsViewItemState.Value(2, "km", 1, Color.Red),
        HabitsViewItemState.Value(3, "km", 5, Color.Red),
        HabitsViewItemState.Value(4, "km", 10, Color.Red),
        HabitsViewItemState.Value(5, "km", 15, Color.Red),
        HabitsViewItemState.Value(6, "km", 20, Color.Red)
    )
    val state1 = HabitsViewRowState(
        1, "row test", 0.7f, yesOrNoList, color = Color.Red
    )
    val state2 = HabitsViewRowState(
        2, "row test 2", 0.5f, valueList, color = Color.Blue
    )
    val tag = "HabitsView"
    Column {
        HabitsViewRow(state = state1) {
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

                is HabitsViewRowEvent.OnRowLongClick -> {
                    Log.d(tag, "Row long clicked: ${it.row.rowId}")
                }
            }
        }
        HabitsViewRow(state = state2) {
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

                is HabitsViewRowEvent.OnRowLongClick -> {
                    Log.d(tag, "Row long clicked: ${it.row.rowId}")
                }
            }
        }
    }
}
