package com.anddev404.show_habits.presentation.edit_top_bar

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.anddev404.R
import com.anddev404.ui.theme.LocalSpacing
import com.anddev404.ui.theme.MainColor


@Composable
fun EditTopBarMenu(
    modifier: Modifier = Modifier,
    textColor: Color = MainColor,
    backgroundColor: Color = Color.White,
    font: FontFamily = FontFamily(Font(R.font.roboto_medium)),
    onEvent: (event: EditTopBarMenuEvent) -> Unit = {}
) {
    Box() {
        DropdownMenu(expanded = true,
            modifier = Modifier
                .background(backgroundColor)
                .then(modifier),
            onDismissRequest = {
                onEvent(EditTopBarMenuEvent.OnDismiss)
            }) {

            DropdownMenuItem(text = {
                Text(
                    text = stringResource(id = R.string.archive),
                    modifier = Modifier.padding(LocalSpacing.current.spaceMediumSmall),
                    color = textColor,
                    fontFamily = font,
                )
            }, onClick = {
                onEvent(EditTopBarMenuEvent.OnArchiveClick)
            })

            DropdownMenuItem(text = {
                Text(
                    text = stringResource(id = R.string.delete),
                    modifier = Modifier.padding(LocalSpacing.current.spaceMediumSmall),
                    color = textColor,
                    fontFamily = font,
                )
            }, onClick = {
                onEvent(EditTopBarMenuEvent.OnDeleteClick)
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EditTopBarMenuPreview() {
    EditTopBarMenu {
        val tag = "EditTopBar"
        when (it) {
            EditTopBarMenuEvent.OnArchiveClick -> Log.d(tag, "clicked: archive")
            EditTopBarMenuEvent.OnDeleteClick -> Log.d(tag, "clicked: delete")
            EditTopBarMenuEvent.OnDismiss -> Log.d(tag, "clicked: dismiss")
        }
    }
}