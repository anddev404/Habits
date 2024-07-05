package com.anddev404.show_habits.components.habits_view.dialogs

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.anddev404.ui.theme.InactiveDarkColor
import com.anddev404.ui.theme.InactiveLightColor
import com.anddev404.ui.theme.LocalSpacing

@Composable
fun HabitsYesOrNoDialog(
    modifier: Modifier = Modifier,
    cardColors: CardColors = CardDefaults.cardColors(containerColor = Color.White),
    checkedColor: Color = Color.DarkGray,
    shape: Shape = RoundedCornerShape(4.dp),
    onCheckedSelected: () -> Unit = {},
    onUnCheckedSelected: () -> Unit = {},
    onDismiss: () -> Unit = {}
) {

    Dialog(onDismissRequest = { onDismiss() }) {
        Card(
            modifier = Modifier
                .padding(LocalSpacing.current.spaceMediumSmall)
                .then(modifier),
            colors = cardColors,
            shape = shape,
        ) {
            Row(
                Modifier
                    .height(IntrinsicSize.Max)
                    .border(2.dp, InactiveLightColor)
            ) {
                IconButton(
                    onClick = { onCheckedSelected() },
                    modifier = Modifier
                        .padding(
                            start = LocalSpacing.current.spaceMedium,
                            end = LocalSpacing.current.spaceMedium
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "",
                        tint = checkedColor
                    )
                }

                Divider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp), color = InactiveLightColor
                )

                IconButton(
                    onClick = { onUnCheckedSelected() },
                    modifier = Modifier
                        .padding(
                            start = LocalSpacing.current.spaceMedium,
                            end = LocalSpacing.current.spaceMedium
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "",
                        tint = InactiveDarkColor
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HabitsYesOrNoDialogPreview() {
    val tag = "HabitsView"
    HabitsYesOrNoDialog(onCheckedSelected = {
        Log.d(tag, "yes")
    }, onUnCheckedSelected = {
        Log.d(tag, "no")
    }) {
        Log.d(tag, "dismiss")
    }
}