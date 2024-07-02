package com.anddev404.main.components.main_top_bar.menus

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.anddev404.R
import com.anddev404.main.components.main_top_bar.events.MainTopBarSortMenuEvent
import com.anddev404.ui.theme.LocalSpacing
import com.anddev404.ui.theme.MainColor

@Composable
fun MainTopBarSortMenu(
    modifier: Modifier = Modifier,
    textColor: Color = MainColor,
    backgroundColor: Color = Color.White,
    font: FontFamily = FontFamily(Font(R.font.roboto_medium)),
    clickEvent: (event: MainTopBarSortMenuEvent) -> Unit = {}
) {
    Box {

        DropdownMenu(expanded = true,
            modifier = Modifier
                .background(backgroundColor)
                .then(modifier),
            onDismissRequest = {
                clickEvent(MainTopBarSortMenuEvent.OnDismissClick)
            }) {

            Text(
                text = stringResource(id = R.string.sort_with_colon),
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                modifier = Modifier.padding(
                    start = LocalSpacing.current.spaceSmall,
                    top = LocalSpacing.current.spaceSmall
                )
            )
            Spacer(modifier = Modifier.height(LocalSpacing.current.spaceMediumSmall))

            DropdownMenuItem(text = {
                Text(
                    modifier = Modifier.padding(LocalSpacing.current.spaceMediumSmall),
                    text = stringResource(id = R.string.manually),
                    color = textColor,
                    fontFamily = font
                )
            }, onClick = {
                clickEvent(MainTopBarSortMenuEvent.OnManuallyClick)
            })

            DropdownMenuItem(text = {
                Text(
                    modifier = Modifier.padding(LocalSpacing.current.spaceMediumSmall),
                    text = stringResource(id = R.string.by_name),
                    color = textColor,
                    fontFamily = font,
                )
            }, onClick = {
                clickEvent(MainTopBarSortMenuEvent.OnByNameClick)
            })

            DropdownMenuItem(text = {
                Text(
                    modifier = Modifier.padding(LocalSpacing.current.spaceMediumSmall),
                    text = stringResource(id = R.string.by_color),
                    color = textColor,
                    fontFamily = font,
                )
            }, onClick = {
                clickEvent(MainTopBarSortMenuEvent.OnByColorClick)
            })

            DropdownMenuItem(text = {
                Text(
                    modifier = Modifier.padding(LocalSpacing.current.spaceMediumSmall),
                    text = stringResource(id = R.string.by_result),
                    color = textColor,
                    fontFamily = font,
                )
            }, onClick = {
                clickEvent(MainTopBarSortMenuEvent.OnByResultClick)
            })

            DropdownMenuItem(text = {
                Text(
                    modifier = Modifier.padding(LocalSpacing.current.spaceMediumSmall),
                    text = stringResource(id = R.string.by_status),
                    color = textColor,
                    fontFamily = font,
                )
            }, onClick = {
                clickEvent(MainTopBarSortMenuEvent.OnByStatusClick)
            })

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainTopBarSortMenuPreview() {
    MainTopBarSortMenu {
        val tag = "MainTopBar"
        when (it) {
            MainTopBarSortMenuEvent.OnByColorClick -> Log.d(tag, "clicked: by color")
            MainTopBarSortMenuEvent.OnByNameClick -> Log.d(tag, "clicked: by name")
            MainTopBarSortMenuEvent.OnByResultClick -> Log.d(tag, "clicked: by result")
            MainTopBarSortMenuEvent.OnByStatusClick -> Log.d(tag, "clicked: by status")
            MainTopBarSortMenuEvent.OnDismissClick -> Log.d(tag, "clicked: dismiss")
            MainTopBarSortMenuEvent.OnManuallyClick -> Log.d(tag, "clicked: manually")
        }
    }
}