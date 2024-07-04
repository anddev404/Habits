package com.anddev404.create_habit.presentation.create_habit_top_bar

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anddev404.R
import com.anddev404.core.presentation.components.defaultPaletteColor
import com.anddev404.ui.theme.LocalSpacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateHabitTopBar(
    contentColor: Color = Color.White,
    backgroundColor: Color = defaultPaletteColor,
    onBackClick: () -> Unit = {},
    onSaveClick: () -> Unit = {}
) {
    TopAppBar(navigationIcon = {
        Icon(
            modifier = Modifier
                .padding(start = LocalSpacing.current.spaceMedium)
                .clickable { onBackClick() },
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "",
            tint = contentColor,
        )
    },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor
        ),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxHeight()
            ) {
                Spacer(modifier = Modifier.width(LocalSpacing.current.spaceMedium))
                Text(
                    stringResource(id = R.string.create_habit),
                    color = contentColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
            }

        },
        actions = {
            OutlinedButton(
                onClick = {
                    onSaveClick()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = backgroundColor,
                    contentColor = contentColor
                ),
                border = BorderStroke(1.dp, contentColor),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(text = stringResource(id = R.string.save))
            }
            Spacer(modifier = Modifier.width(LocalSpacing.current.spaceSmall))
        })
}

@Preview(showBackground = true)
@Composable
private fun CreateHabitTopBarPreview() {
    val tag = "createHabitView"

    CreateHabitTopBar(backgroundColor = defaultPaletteColor, onBackClick = {
        Log.d(tag, "clicked: back")
    }, onSaveClick = { Log.d(tag, "clicked: save") })
}