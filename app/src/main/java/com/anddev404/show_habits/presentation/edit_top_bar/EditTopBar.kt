package com.anddev404.show_habits.presentation.edit_top_bar

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.anddev404.R
import com.anddev404.core.presentation.components.ColorPaletteDialog
import com.anddev404.show_habits.presentation.edit_top_bar.menus.EditTopBarMenu
import com.anddev404.show_habits.presentation.edit_top_bar.menus.EditTopBarMenuEvent
import com.anddev404.ui.theme.LocalSpacing
import com.anddev404.ui.theme.MainLightColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTopBar(
    contentColor: Color = Color.White,
    backgroundColor: Color = MainLightColor,
    selectedIds: List<Int> = listOf(),
    onEvent: (event: EditTopBarEvent) -> Unit = {}
) {
    TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
        containerColor = backgroundColor,
    ), navigationIcon = {
        Icon(
            modifier = Modifier
                .padding(start = LocalSpacing.current.spaceMedium)
                .clickable { onEvent(EditTopBarEvent.OnBackClick) },
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "",
            tint = contentColor,
        )
    }, title = {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxHeight()
        ) {
            Spacer(modifier = Modifier.width(LocalSpacing.current.spaceMedium))
            Text(
                text = "${selectedIds.size}",
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
            if (selectedIds.size == 1) {
                Icon(imageVector = Icons.Default.Edit,
                    "",
                    tint = Color.White,
                    modifier = Modifier.clickable {
                        onEvent(
                            EditTopBarEvent.OnEditClick(
                                selectedIds[0]
                            )
                        )
                    })
            }

            var showColorPalette by remember { mutableStateOf(false) }
            if (showColorPalette) {
                ColorPaletteDialog() { color ->
                    if (color != 0) {
                        onEvent(EditTopBarEvent.OnChangeColorClick(selectedIds, color))
                    }
                    showColorPalette = false
                }
            }
            Spacer(modifier = Modifier.width(LocalSpacing.current.spaceMedium))
            Icon(imageVector = ImageVector.vectorResource(id = R.drawable.baseline_color_lens_24),
                "",
                tint = Color.White,
                modifier = Modifier.clickable { showColorPalette = true })

            var showMenu by remember { mutableStateOf(false) }
            if (showMenu) {
                EditTopBarMenu() {
                    when (it) {
                        EditTopBarMenuEvent.OnArchiveClick -> onEvent(
                            EditTopBarEvent.OnArchiveClick(
                                selectedIds
                            )
                        )

                        EditTopBarMenuEvent.OnDeleteClick -> onEvent(
                            EditTopBarEvent.OnDeleteClick(
                                selectedIds
                            )
                        )

                        EditTopBarMenuEvent.OnDismiss -> {}
                    }
                    showMenu = false
                }
            }

            Spacer(modifier = Modifier.width(LocalSpacing.current.spaceMedium))
            Icon(imageVector = Icons.Default.MoreVert,
                "",
                tint = Color.White,
                modifier = Modifier.clickable { showMenu = !showMenu })

            Spacer(modifier = Modifier.width(LocalSpacing.current.spaceExtraSmall))
        }
    })
}

@Preview(showBackground = true)
@Composable
fun EditTopBarPreview() {
    Column {
        val tag = "EditTopBar"
        EditTopBar(selectedIds = arrayListOf(1))
        EditTopBar(selectedIds = arrayListOf(1, 2)) {
            when (it) {
                is EditTopBarEvent.OnArchiveClick -> Log.d(
                    tag,
                    "clicked: archive ${it.ids.size} habits"
                )

                EditTopBarEvent.OnBackClick -> Log.d(tag, "clicked: back")
                is EditTopBarEvent.OnChangeColorClick -> Log.d(
                    tag,
                    "clicked: change color: ${it.color} in ${it.ids.size} habits"
                )

                is EditTopBarEvent.OnDeleteClick -> Log.d(
                    tag,
                    "clicked: delete ${it.ids.size} habits"
                )

                is EditTopBarEvent.OnEditClick -> Log.d(tag, "clicked: edit id=${it.id}")
            }
        }
    }
}
