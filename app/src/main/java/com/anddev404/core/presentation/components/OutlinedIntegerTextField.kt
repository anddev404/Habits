package com.anddev404.core.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedIntegerTextField(value: Int = 0, onDone: (value: Int) -> Unit = {}) {

    var text by remember { mutableStateOf(TextFieldValue(value.toString())) }
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        modifier = Modifier.width(64.dp),
        value = if (isCorrect(text)) text else TextFieldValue(),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White, focusedContainerColor = Color.White
        ),
        onValueChange = {
            if (isCorrect(it)) text = it else return@OutlinedTextField
        },
        keyboardActions = KeyboardActions(onDone = {
            if (isCorrect(text)) onDone(text.text.ToIntOrDefault(value))
            keyboardController?.hide()
        }),
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Done
        )
    )
}

private fun isCorrect(textFieldValue: TextFieldValue): Boolean {
    if (textFieldValue.text.length > 2) return false
    if (textFieldValue.text == "0") return false
    if (textFieldValue.text == "") return true
    if (textFieldValue.text.all { it.isDigit() }) {
        return textFieldValue.text.toInt() > 0
    }
    return false
}

fun String.ToIntOrDefault(defaultValue: Int = 0): Int {
    try {
        return this.toInt()
    } catch (n: NumberFormatException) {
        return defaultValue
    }
}

@Preview
@Composable
private fun OutlinedIntegerTextFieldPreview() {
    OutlinedIntegerTextField() {
        Log.d("OutlinedIntegerTextField", "OutlinedIntegerTextField: ${it}")
    }
}