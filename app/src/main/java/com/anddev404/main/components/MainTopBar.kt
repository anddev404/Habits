package com.anddev404.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.anddev404.R
import com.anddev404.ui.theme.LocalSpacing
import com.anddev404.ui.theme.MainColor


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MainTopBar() {
    TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
        containerColor = MainColor
    ), title = {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxHeight()
        ) {
            Text(
                stringResource(id = R.string.app_name),
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )
        }

    }, actions = {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxHeight()
        ) {

            Icon(
                imageVector = Icons.Default.Add,
                "",
                tint = Color.White,
                modifier = Modifier.clickable {})

            Spacer(modifier = Modifier.width(LocalSpacing.current.spaceMedium))

            Icon(
                painter = painterResource(id = R.drawable.ic_filter_list),
                "",
                tint = Color.White,
                modifier = Modifier.clickable {})

            Spacer(modifier = Modifier.width(LocalSpacing.current.spaceMedium))

            var expandedMainMenu by remember { mutableStateOf(false) }
            if (expandedMainMenu) {
                MainTopBarMainMenu {
                    when (it) {
                        MainTopBarMainMenuEvent.OnAboutClick -> TODO()
                        MainTopBarMainMenuEvent.OnSettingsClick -> TODO()
                        MainTopBarMainMenuEvent.OnSupportClick -> TODO()
                        MainTopBarMainMenuEvent.OnCloseClick -> expandedMainMenu = false
                        is MainTopBarMainMenuEvent.OnToggleNightModeClick -> TODO()
                    }
                }
            }

            Icon(imageVector = Icons.Default.MoreVert,
                "",
                tint = Color.White,
                modifier = Modifier.clickable { expandedMainMenu = !expandedMainMenu })

            Spacer(modifier = Modifier.width(LocalSpacing.current.spaceExtraSmall))

        }
    })
}
