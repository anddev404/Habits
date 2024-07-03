package com.anddev404.habits.components.main_top_bar.dialogs

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.anddev404.R
import com.anddev404.ui.theme.LocalSpacing


@Composable
fun MainTopBarDialog(
    modifier: Modifier = Modifier,
    cardColors: CardColors = CardDefaults.cardColors(containerColor = Color.White),
    textColor: Color = Color.Unspecified,
    shape: Shape = RoundedCornerShape(4.dp),
    header1: String = stringResource(id = R.string.yes_or_no),
    description1: String = stringResource(id = R.string.yes_or_no_description),
    header2: String = stringResource(id = R.string.measurable),
    description2: String = stringResource(id = R.string.measurable_description),
    firstCardSelected: () -> Unit = {},
    secondCardSelected: () -> Unit = {},
    onDismiss: () -> Unit = {}
) {

    Row {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(modifier = Modifier.width(IntrinsicSize.Max)) {
                Card(
                    modifier = Modifier
                        .padding(LocalSpacing.current.spaceMediumSmall)
                        .clickable { firstCardSelected() }
                        .then(modifier)
                        .fillMaxWidth(),
                    colors = cardColors,
                    shape = shape,
                ) {
                    Column(modifier = Modifier.padding(LocalSpacing.current.spaceMediumSmall)) {
                        Text(
                            text = header1,
                            color = textColor,
                            modifier = Modifier
                                .wrapContentSize(Alignment.Center)
                                .padding(bottom = LocalSpacing.current.spaceSmall),
                            fontSize = MaterialTheme.typography.titleLarge.fontSize,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.roboto_medium))
                        )
                        Text(
                            text = description1,
                            color = textColor,
                            modifier = Modifier.wrapContentSize(Alignment.Center),
                            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                            textAlign = TextAlign.Start,
                        )
                    }

                }

                Card(
                    modifier = Modifier
                        .padding(LocalSpacing.current.spaceMediumSmall)
                        .clickable { secondCardSelected() }
                        .then(modifier)
                        .fillMaxWidth(),
                    colors = cardColors,
                    shape = shape,
                ) {
                    Column(modifier = Modifier.padding(LocalSpacing.current.spaceMediumSmall)) {
                        Text(
                            text = header2,
                            color = textColor,
                            modifier = Modifier
                                .wrapContentSize(Alignment.Center)
                                .padding(bottom = LocalSpacing.current.spaceSmall),
                            fontSize = MaterialTheme.typography.titleLarge.fontSize,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.roboto_medium))
                        )
                        Text(
                            text = description2,
                            color = textColor,
                            modifier = Modifier.wrapContentSize(Alignment.Center),
                            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                            textAlign = TextAlign.Start,
                        )
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainTopBarDialogPreview() {
    val tag = "MainTopBar"
    MainTopBarDialog(firstCardSelected = { Log.d(tag, "first card selected") },
        secondCardSelected = { Log.d(tag, "second card selected") }) {
        Log.d(tag, "dismiss")
    }
}