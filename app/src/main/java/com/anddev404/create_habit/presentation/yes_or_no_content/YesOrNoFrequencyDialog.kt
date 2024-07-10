package com.anddev404.create_habit.presentation.yes_or_no_content

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.anddev404.R
import com.anddev404.core.presentation.components.OutlinedIntegerTextField
import com.anddev404.ui.theme.LocalSpacing

@Composable
fun YesOrNoFrequencyDialog(
    state: YesOrNoFrequencyState = YesOrNoFrequencyState.DAILY,
    cardColors: CardColors = CardDefaults.cardColors(containerColor = Color.White),
    shape: Shape = RoundedCornerShape(2.dp),
    onDismiss: () -> Unit = {},
    onState: (state: YesOrNoFrequencyState) -> Unit = {},
) {
    Dialog(onDismissRequest = { onDismiss() }) {
        Card(
            modifier = Modifier.padding(LocalSpacing.current.spaceMediumSmall),
            shape = shape,
            colors = cardColors,

            ) {
            Column(
                Modifier
                    .padding(LocalSpacing.current.spaceMedium)
                    .width(IntrinsicSize.Max),
            ) {
                var selected by remember { mutableStateOf(state) }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = shouldBeSelected(
                        selected, YesOrNoFrequencyState.DAILY
                    ),
                        onClick = {
                            selected =
                                YesOrNoFrequencyState.DAILY
                        })
                    Text(text = stringResource(R.string.daily), Modifier.clickable {
                        selected = YesOrNoFrequencyState.DAILY
                    })
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = LocalSpacing.current.spaceMedium),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = shouldBeSelected(
                        selected, YesOrNoFrequencyState.INTERVAL
                    ), onClick = {
                        selected = YesOrNoFrequencyState.INTERVAL
                    })
                    Text(
                        text = stringResource(R.string.interval_start_text),
                        Modifier.padding(end = LocalSpacing.current.spaceMediumSmall)
                    )
                    OutlinedIntegerTextField(YesOrNoFrequencyState.INTERVAL.frequency) {
                        selected = YesOrNoFrequencyState.INTERVAL.apply {
                            frequency = it
                        }
                    }
                    Text(
                        text = stringResource(R.string.interval_end_text),
                        Modifier.padding(start = LocalSpacing.current.spaceMediumSmall)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = LocalSpacing.current.spaceMedium),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = shouldBeSelected(
                        selected, YesOrNoFrequencyState.WEEKLY
                    ), onClick = {
                        selected = YesOrNoFrequencyState.WEEKLY
                    })
                    OutlinedIntegerTextField(YesOrNoFrequencyState.WEEKLY.frequency) {
                        selected = YesOrNoFrequencyState.WEEKLY.apply {
                            frequency = it
                        }
                    }
                    Text(
                        text = stringResource(R.string.weekly),
                        Modifier.padding(start = LocalSpacing.current.spaceMediumSmall)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = LocalSpacing.current.spaceMedium),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = shouldBeSelected(
                        selected, YesOrNoFrequencyState.MONTHLY
                    ), onClick = {
                        selected = YesOrNoFrequencyState.MONTHLY
                    })
                    OutlinedIntegerTextField(YesOrNoFrequencyState.MONTHLY.frequency) {
                        selected = YesOrNoFrequencyState.MONTHLY.apply {
                            frequency = it
                        }
                    }
                    Text(
                        text = stringResource(R.string.monthly),
                        Modifier.padding(start = LocalSpacing.current.spaceMediumSmall)
                    )
                }
                Text(
                    stringResource(id = R.string.save),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = LocalSpacing.current.spaceLarge)
                        .clickable {
                            onState(selected)
                        },
                    textAlign = TextAlign.End
                )
            }
        }
    }
}

private fun shouldBeSelected(
    state: YesOrNoFrequencyState, viewState: YesOrNoFrequencyState
): Boolean {
    return viewState == state
}

@Preview
@Composable
private fun YesOrNoFrequencyDialogPreview() {
    val context = LocalContext.current

    YesOrNoFrequencyDialog(onDismiss = {
        Log.d(
            "YesOrNoFrequencyDialog", "dismiss"
        )
    }) {
        Log.d(
            "YesOrNoFrequencyDialog", it.toString(context)
        )
    }
}