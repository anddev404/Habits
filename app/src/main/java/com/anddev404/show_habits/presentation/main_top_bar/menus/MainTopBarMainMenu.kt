package com.anddev404.show_habits.components.main_top_bar.menus

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.anddev404.R
import com.anddev404.show_habits.components.main_top_bar.events.MainTopBarMainMenuEvent
import com.anddev404.ui.theme.LocalSpacing
import com.anddev404.ui.theme.MainColor

@Composable
fun MainTopBarMainMenu(
    modifier: Modifier = Modifier,
    textColor: Color = MainColor,
    backgroundColor: Color = Color.White,
    font: FontFamily = FontFamily(Font(R.font.roboto_medium)),
    isNightMode: Boolean = false,
    clickEvent: (event: MainTopBarMainMenuEvent) -> Unit = {}
) {
    Box {
        DropdownMenu(expanded = true,
            modifier = Modifier
                .background(backgroundColor)
                .then(modifier),
            onDismissRequest = {
                clickEvent(MainTopBarMainMenuEvent.OnCloseClick)
            }) {

            var isCheckedNightMode by remember { mutableStateOf(isNightMode) }

            DropdownMenuItem(text = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(id = R.string.night_mode),
                        modifier = Modifier.padding(LocalSpacing.current.spaceMediumSmall),
                        color = textColor,
                        fontFamily = font,
                    )
                    Checkbox(
                        checked = isCheckedNightMode, onCheckedChange = {
                            isCheckedNightMode = !isCheckedNightMode
                            clickEvent(
                                MainTopBarMainMenuEvent.OnToggleNightModeClick(
                                    isCheckedNightMode
                                )
                            )
                        }, modifier = Modifier.padding(
                                start = LocalSpacing.current.spaceMediumSmall,
                                end = LocalSpacing.current.spaceMediumSmall
                            )
                    )
                }
            }, onClick = {
                isCheckedNightMode = !isCheckedNightMode
                clickEvent(MainTopBarMainMenuEvent.OnToggleNightModeClick(isCheckedNightMode))
            })

            DropdownMenuItem(text = {
                Text(
                    text = stringResource(id = R.string.settings),
                    modifier = Modifier.padding(LocalSpacing.current.spaceMediumSmall),
                    color = textColor,
                    fontFamily = font,

                    )
            }, onClick = {
                clickEvent(MainTopBarMainMenuEvent.OnSettingsClick)
            })

            DropdownMenuItem(text = {
                Text(
                    text = stringResource(id = R.string.support),
                    modifier = Modifier.padding(LocalSpacing.current.spaceMediumSmall),
                    color = textColor,
                    fontFamily = font
                )
            }, onClick = {
                clickEvent(MainTopBarMainMenuEvent.OnSupportClick)
            })

            DropdownMenuItem(text = {
                Text(
                    text = stringResource(id = R.string.about),
                    modifier = Modifier.padding(LocalSpacing.current.spaceMediumSmall),
                    color = textColor,
                    fontFamily = font
                )
            }, onClick = {
                clickEvent(MainTopBarMainMenuEvent.OnAboutClick)
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainTopBarMainMenuPreview() {
    MainTopBarMainMenu {
        val tag = "MainTopBar"
        when (it) {
            MainTopBarMainMenuEvent.OnAboutClick -> Log.d(tag, "clicked about")
            MainTopBarMainMenuEvent.OnSettingsClick -> Log.d(tag, "clicked settings")
            MainTopBarMainMenuEvent.OnSupportClick -> Log.d(tag, "clicked support")
            MainTopBarMainMenuEvent.OnCloseClick -> Log.d(tag, "close menu")
            is MainTopBarMainMenuEvent.OnToggleNightModeClick -> Log.d(
                tag, "clicked night mode ${it.darkMode}"
            );
        }
    }
}
