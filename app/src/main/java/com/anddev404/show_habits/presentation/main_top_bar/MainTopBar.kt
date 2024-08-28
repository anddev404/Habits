package com.anddev404.show_habits.presentation.main_top_bar

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.anddev404.R
import com.anddev404.show_habits.components.main_top_bar.events.MainTopBarFilterMenuEvent
import com.anddev404.show_habits.components.main_top_bar.events.MainTopBarMainMenuEvent
import com.anddev404.show_habits.components.main_top_bar.events.MainTopBarSortMenuEvent
import com.anddev404.show_habits.components.main_top_bar.menus.MainTopBarFilterMenu
import com.anddev404.show_habits.components.main_top_bar.menus.MainTopBarMainMenu
import com.anddev404.show_habits.components.main_top_bar.menus.MainTopBarSortMenu
import com.anddev404.show_habits.presentation.main_top_bar.dialogs.MainTopBarDialog
import com.anddev404.ui.theme.LocalSpacing
import com.anddev404.ui.theme.MainColor


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MainTopBar(onEvent: (MainTopBarEvents) -> Unit = {}) {

    val context = LocalContext.current

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

            var showDialog by remember { mutableStateOf(false) }
            if (showDialog) {
                MainTopBarDialog(onDismiss = { showDialog = false }) {
                    showDialog = false
                    onEvent(MainTopBarEvents.OnAddHabitClick(it))
                }
            }
            Icon(
                imageVector = Icons.Default.Add,
                "",
                tint = Color.White,
                modifier = Modifier.clickable { showDialog = true })

            Spacer(modifier = Modifier.width(LocalSpacing.current.spaceMedium))

            var expandedSortMenu by remember { mutableStateOf(false) }
            if (expandedSortMenu) {
                MainTopBarSortMenu {
                    when (it) {
                        MainTopBarSortMenuEvent.OnByColorClick -> showNotAvailableYetToast(
                            context
                        )

                        MainTopBarSortMenuEvent.OnByNameClick -> showNotAvailableYetToast(
                            context
                        )

                        MainTopBarSortMenuEvent.OnByResultClick -> showNotAvailableYetToast(
                            context
                        )

                        MainTopBarSortMenuEvent.OnByStatusClick -> showNotAvailableYetToast(
                            context
                        )

                        MainTopBarSortMenuEvent.OnDismissClick -> expandedSortMenu = false
                        MainTopBarSortMenuEvent.OnManuallyClick -> showNotAvailableYetToast(
                            context
                        )
                    }
                }
            }

            var expandedFilterMenu by remember { mutableStateOf(false) }
            if (expandedFilterMenu) {
                MainTopBarFilterMenu {
                    when (it) {
                        MainTopBarFilterMenuEvent.OnExitClick -> expandedFilterMenu = false
                        MainTopBarFilterMenuEvent.OnSortClick -> {
                            expandedFilterMenu = false
                            expandedSortMenu = true

                        }

                        is MainTopBarFilterMenuEvent.OnToggleHideArchived -> showNotAvailableYetToast(
                            context
                        )

                        is MainTopBarFilterMenuEvent.OnToggleHideCompleted -> showNotAvailableYetToast(
                            context
                        )
                    }
                }
            }

            Icon(
                painter = painterResource(id = R.drawable.ic_filter_list),
                "",
                tint = Color.White,
                modifier = Modifier.clickable { expandedFilterMenu = !expandedFilterMenu })

            Spacer(modifier = Modifier.width(LocalSpacing.current.spaceMedium))

            var expandedMainMenu by remember { mutableStateOf(false) }
            if (expandedMainMenu) {
                MainTopBarMainMenu {
                    when (it) {
                        MainTopBarMainMenuEvent.OnAboutClick -> showNotAvailableYetToast(context)
                        MainTopBarMainMenuEvent.OnSettingsClick -> showNotAvailableYetToast(
                            context
                        )

                        MainTopBarMainMenuEvent.OnSupportClick -> showNotAvailableYetToast(
                            context
                        )

                        MainTopBarMainMenuEvent.OnCloseClick -> expandedMainMenu = false
                        is MainTopBarMainMenuEvent.OnToggleNightModeClick -> showNotAvailableYetToast(
                            context
                        )

                        MainTopBarMainMenuEvent.OnContactClick -> sendEmail(context)
                        MainTopBarMainMenuEvent.OnPrivacyPolicyClick -> openPrivacyPolicy(
                            context
                        )
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

private fun openPrivacyPolicy(context: Context) {
    val url = "https://anddev404.github.io/AimTrainer/privacy_policy/Privacy_Policy.htm"

    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

private fun sendEmail(context: Context) {
    val emailIntent = Intent(Intent.ACTION_SEND)

    emailIntent.type = "text/plain"
    emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("anddev404@gmail.com"))
    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Habbits")
    emailIntent.putExtra(Intent.EXTRA_TEXT, "")

    context.startActivity(Intent.createChooser(emailIntent, "Send mail..."))
}

private fun showNotAvailableYetToast(context: Context) {
    Toast.makeText(context, "Not available yet!", Toast.LENGTH_SHORT).show();
}