package com.anddev404.show_habits.components.main_top_bar.menus

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.anddev404.R
import com.anddev404.show_habits.components.main_top_bar.events.MainTopBarFilterMenuEvent
import com.anddev404.ui.theme.LocalSpacing
import com.anddev404.ui.theme.MainColor


@Composable
fun MainTopBarFilterMenu(
    modifier: Modifier = Modifier,
    textColor: Color = MainColor,
    backgroundColor: Color = Color.White,
    font: FontFamily = FontFamily(Font(R.font.roboto_medium)),
    isHideArchived: Boolean = false,
    isHideCompleted: Boolean = false,
    clickEvent: (event: MainTopBarFilterMenuEvent) -> Unit = {}
) {
    Box() {
        DropdownMenu(expanded = true,
            modifier = Modifier
                .background(backgroundColor)
                .then(modifier),
            onDismissRequest = {
                clickEvent(MainTopBarFilterMenuEvent.OnExitClick)
            }) {

            var isCheckedHideArchived by remember { mutableStateOf(isHideArchived) }

            Column(modifier = Modifier.width(IntrinsicSize.Max)) {
                DropdownMenuItem(text = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.hide_archived),
                            modifier = Modifier.padding(LocalSpacing.current.spaceMediumSmall),
                            color = textColor,
                            fontFamily = font,
                        )
                        Checkbox(
                            checked = isCheckedHideArchived, onCheckedChange = {
                                isCheckedHideArchived = !isCheckedHideArchived
                                clickEvent(
                                    MainTopBarFilterMenuEvent.OnToggleHideArchived(
                                        isCheckedHideArchived
                                    )
                                )
                            }, modifier = Modifier.padding(
                                start = LocalSpacing.current.spaceMediumSmall,
                                end = LocalSpacing.current.spaceMediumSmall
                            )
                        )
                    }
                }, onClick = {
                    isCheckedHideArchived = !isCheckedHideArchived
                    clickEvent(
                        MainTopBarFilterMenuEvent.OnToggleHideArchived(
                            isCheckedHideArchived
                        )
                    )
                })

                var isCheckedHideCompleted by remember { mutableStateOf(isHideCompleted) }

                DropdownMenuItem(text = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.hide_completed),
                            modifier = Modifier.padding(LocalSpacing.current.spaceMediumSmall),
                            color = textColor,
                            fontFamily = font,
                        )
                        Checkbox(
                            checked = isCheckedHideCompleted, onCheckedChange = {
                                isCheckedHideCompleted = !isCheckedHideCompleted
                                clickEvent(
                                    MainTopBarFilterMenuEvent.OnToggleHideCompleted(
                                        isCheckedHideCompleted
                                    )
                                )
                            }, modifier = Modifier.padding(
                                start = LocalSpacing.current.spaceMediumSmall,
                                end = LocalSpacing.current.spaceMediumSmall
                            )
                        )
                    }
                }, onClick = {
                    isCheckedHideCompleted = !isCheckedHideCompleted
                    clickEvent(
                        MainTopBarFilterMenuEvent.OnToggleHideCompleted(
                            isCheckedHideCompleted
                        )
                    )
                })

                DropdownMenuItem(text = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.sort),
                            modifier = Modifier.padding(LocalSpacing.current.spaceMediumSmall),
                            color = textColor,
                            fontFamily = font,
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_right),
                            "",
                            modifier = Modifier.padding(end = LocalSpacing.current.spaceMedium),

                            )
                    }
                }, onClick = {
                    clickEvent(MainTopBarFilterMenuEvent.OnSortClick)
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainTopBarFilterMenuPreview() {
    MainTopBarFilterMenu {
        val tag = "MainTopBar"
        when (it) {
            MainTopBarFilterMenuEvent.OnExitClick -> Log.d(tag, "clicked: exit")
            MainTopBarFilterMenuEvent.OnSortClick -> Log.d(tag, "clicked: sort")
            is MainTopBarFilterMenuEvent.OnToggleHideArchived -> Log.d(
                tag, "clicked: hide archived ${it.hideArchived}"
            )

            is MainTopBarFilterMenuEvent.OnToggleHideCompleted -> Log.d(
                tag, "clicked: hide completed ${it.hideCompleted}"
            )
        }
    }
}


