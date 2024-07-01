package com.anddev404.main.components

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
    checkedColor: Color = InactiveDarkColor,
    isChecked: Boolean = false,
    onClick: (Boolean) -> Unit = {}
) {

    if (isChecked) {
        IconButton(modifier = Modifier
            .size(LocalSpacing.current.habitItemSize),
            onClick = { onClick(true) }
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
            onClick = { onClick(false) }
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
    HabitsYesOrNoItem(Color.Blue, true) {
        Log.d(tag, "clicked: $it")
    }

}

@Preview(showBackground = true)
@Composable
private fun HabitsYesOrNoItemPreview2() {
//    Log.d(tag, "dismiss")
    val tag = "HabitsView"
    HabitsYesOrNoItem() {
        Log.d(tag, "clicked: $it")
    }

}