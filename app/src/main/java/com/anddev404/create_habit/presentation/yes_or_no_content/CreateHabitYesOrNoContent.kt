package com.anddev404.create_habit.presentation.yes_or_no_content

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.anddev404.R

@Composable
fun CreateHabitYesOrNoContent(
    state: YesOrNoFrequencyState = YesOrNoFrequencyState.DAILY
) {
    var showDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .width(IntrinsicSize.Max)
            .height(IntrinsicSize.Max)
    ) {

        val context = LocalContext.current
        var chosenOption by remember { mutableStateOf(state) }

        if (showDialog) {
            YesOrNoFrequencyDialog(chosenOption, onDismiss = { showDialog = false }) {
                chosenOption = it
                showDialog = false
            }
        }
        OutlinedTextField(
            value = chosenOption.toString(context),
            readOnly = true,
            onValueChange = {},
            maxLines = 1,
            label = { Text(text = stringResource(id = R.string.frequency)) },
            trailingIcon = {
                Icon(imageVector = Icons.Default.ArrowDropDown, "")
            }
        )

        Box(modifier = Modifier
            .fillMaxSize()
            .clickable { showDialog = true }) {
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CreateHabitYesOrNoContentPreview() {
    CreateHabitYesOrNoContent()
}