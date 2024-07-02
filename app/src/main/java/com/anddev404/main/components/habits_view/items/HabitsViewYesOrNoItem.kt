package com.anddev404.main.components.habits_view.items

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
import com.anddev404.ui.theme.InactiveDarkColor
import com.anddev404.ui.theme.InactiveLightColor
import com.anddev404.ui.theme.LocalSpacing


@Composable
fun HabitsYesOrNoItem(
    id: Int = 0,
    isChecked: Boolean = false,
    checkedColor: Color = InactiveDarkColor,
    onClick: (id: Int, isChecked: Boolean) -> Unit = { _, _ -> }
) {

    if (isChecked) {
        IconButton(modifier = Modifier
            .size(LocalSpacing.current.habitItemSize),
            onClick = { onClick(id, true) }
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "",
                tint = checkedColor
            )
        }
    } else {
        IconButton(modifier = Modifier
            .size(LocalSpacing.current.habitItemSize),
            onClick = { onClick(id, false) }
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
    HabitsYesOrNoItem(1, checkedColor = Color.Blue, isChecked = true) { id, isChecked ->
        Log.d(tag, "clicked: $id  $isChecked")
    }

}

@Preview(showBackground = true)
@Composable
private fun HabitsYesOrNoItemPreview2() {
    val tag = "HabitsView"
    HabitsYesOrNoItem(2) { id, isChecked ->
        Log.d(tag, "clicked: $id  $isChecked")
    }
}