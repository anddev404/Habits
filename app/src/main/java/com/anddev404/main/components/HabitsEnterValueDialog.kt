package com.anddev404.main.components

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.anddev404.R
import com.anddev404.ui.theme.InactiveLightColor
import com.anddev404.ui.theme.LocalSpacing

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HabitsEnterValueDialog(
    modifier: Modifier = Modifier,
    cardColors: CardColors = CardDefaults.cardColors(containerColor = Color.White),
    shape: Shape = RoundedCornerShape(4.dp),
    value: Int = 0,
    onValue: (Int) -> Unit = {},
    onDismiss: () -> Unit = {}
) {

    Dialog(onDismissRequest = { onDismiss() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(LocalSpacing.current.spaceMediumSmall)
                .then(modifier),
            colors = cardColors,
            shape = shape,
        ) {
            Row(
                Modifier
                    .height(IntrinsicSize.Max)
                    .border(2.dp, InactiveLightColor)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                var text by remember { mutableStateOf(TextFieldValue(value.toString())) }
                val keyboardController = LocalSoftwareKeyboardController.current

                TextField(
                    modifier = Modifier.weight(1f),
                    value = if (isCorrect(text)) text else TextFieldValue(),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White, focusedContainerColor = Color.White
                    ),
                    onValueChange = {
                        if (isCorrect(it)) text = it else return@TextField
                    },
                    keyboardActions = KeyboardActions(onDone = {
                        keyboardController?.hide()
                    }),
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Done
                    )
                )

                Divider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp), color = InactiveLightColor
                )

                Button(
                    onClick = {
                        keyboardController?.hide()
                        onValue(text.text.toInt())
                    },
                    modifier = Modifier.fillMaxHeight(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Unspecified, contentColor = Black
                    )
                ) {
                    Text(text = stringResource(id = R.string.save))
                }
            }
        }
    }
}

private fun isCorrect(textFieldValue: TextFieldValue): Boolean {
    if (textFieldValue.text == "") return true
    if (textFieldValue.text.all { it.isDigit() }) {
        return textFieldValue.text.toInt() > 0
    }
    if (textFieldValue.text == "0") return false
    if (textFieldValue.text.length > 10) return false
    return false
}

@Preview(showBackground = true)
@Composable
private fun HabitsEnterValueDialogPreview() {
    val tag = "HabitsView"
    HabitsEnterValueDialog(value = 123, onValue = {
        Log.d(tag, "value = $it")
    }) { Log.d(tag, "dismiss") }
}