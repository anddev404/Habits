package com.anddev404.core.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.anddev404.R

@Composable
fun ErrorHandlingOutlinedTextField(
    modifier: Modifier = Modifier,
    value: TextFieldValue = TextFieldValue(),
    onValueChange: (TextFieldValue) -> Unit = {},
    label: String = "",
    placeholder: String = "",
    isValid: Boolean = true,
    errorText: String = ""
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
        isError = !isValid,
        trailingIcon = {
            if (!isValid) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.error_icon),
                    contentDescription = ""
                )
            }
        },
        supportingText = {
            if (!isValid) {
                Text(text = errorText)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ErrorHandlingOutlinedTextFieldPreview() {
    Column {
        ErrorHandlingOutlinedTextField(isValid = true, errorText = "Error ...")
        ErrorHandlingOutlinedTextField(isValid = false, errorText = "Error ...")
        ErrorHandlingOutlinedTextField(isValid = true, errorText = "Error ...")
    }


}