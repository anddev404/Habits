package com.anddev404.show_habits.presentation.habits_view

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.anddev404.R
import com.anddev404.ui.theme.TextColor

@Preview(showBackground = true)
@Composable
fun HabitsEmptyView() {

    val imageWidth =
        if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT) {
            0.4f
        } else {
            0.2f
        }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(imageWidth)
                .aspectRatio(1f),
            imageVector = ImageVector.vectorResource(R.drawable.half_star),
            contentDescription = "",
            colorFilter = ColorFilter.tint(TextColor)
        )
        Text(text = stringResource(id = R.string.no_habits), color = TextColor)
    }
}