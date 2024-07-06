package com.anddev404.show_habits.presentation.habits_view.items

import android.util.Log
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.anddev404.show_habits.presentation.habits_view.states.HabitsViewItemState
import com.anddev404.ui.theme.InactiveLightColor
import com.anddev404.ui.theme.LocalSpacing


@Composable
fun HabitsYesOrNoItem(
    state: HabitsViewItemState.YesOrNo,
    onClick: (HabitsViewItemState.YesOrNo) -> Unit = { }
) {
    if (state.isChecked) {
        IconButton(modifier = Modifier
            .size(LocalSpacing.current.habitItemSize),
            onClick = {
                onClick(state)
            }
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "",
                tint = state.color
            )
        }
    } else {
        IconButton(modifier = Modifier
            .size(LocalSpacing.current.habitItemSize),
            onClick = {
                onClick(state)
            }
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "",
                tint = InactiveLightColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HabitsYesOrNoItemPreview1() {
    val tag = "HabitsView"
    HabitsYesOrNoItem(
        HabitsViewItemState.YesOrNo(
            1,
            isChecked = true,
            color = Color.Blue,
        )
    ) {
        Log.d(tag, "clicked: ${it.id}  ${it.isChecked}")
    }

}

@Preview(showBackground = true)
@Composable
private fun HabitsYesOrNoItemPreview2() {
    val tag = "HabitsView"
    HabitsYesOrNoItem(
        HabitsViewItemState.YesOrNo(
            2,
            isChecked = false,
            color = Color.Green,
        )
    ) {
        Log.d(tag, "clicked: ${it.id}  ${it.isChecked}")
    }
}