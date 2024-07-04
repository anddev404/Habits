package com.anddev404.core.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.anddev404.R
import com.anddev404.ui.theme.LocalSpacing

@Composable
fun ColorPaletteDialog(
    checkedArgbColor: Int = 0,
    cardColors: CardColors = CardDefaults.cardColors(containerColor = Color.White),
    shape: Shape = RoundedCornerShape(2.dp),
    onEvent: (colorOrDismiss: Int) -> Unit = {}
) {
    Dialog(onDismissRequest = { onEvent(0) }) {
        Card(
            modifier = Modifier
                .padding(LocalSpacing.current.spaceMediumSmall),
            shape = shape,
            colors = cardColors,

            ) {
            Column(
                Modifier.padding(LocalSpacing.current.spaceMedium),
            ) {

                Text(
                    text = stringResource(id = R.string.change_color),
                    fontSize = LocalSpacing.current.fontSizeLarge,
                    fontFamily = FontFamily(Font(R.font.roboto_medium))
                )

                Spacer(modifier = Modifier.height(LocalSpacing.current.spaceLarge))

                LazyVerticalGrid(
                    modifier = Modifier.padding(
                        start = LocalSpacing.current.spaceSmall,
                        end = LocalSpacing.current.spaceSmall
                    ),
                    columns = GridCells.Fixed(4)

                ) {
                    itemsIndexed(colors()) { _, item ->
                        val isChecked = item.toArgb() == checkedArgbColor

                        ColorPaletteItem(
                            modifier = Modifier.padding(LocalSpacing.current.spaceExtraSmall),
                            isChecked,
                            color = item
                        ) {
                            onEvent(item.toArgb())
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ColorPaletteDialogPreview() {
    Box(modifier = Modifier.wrapContentWidth()) {
        ColorPaletteDialog(checkedArgbColor = Color(0xFF1976D3).toArgb()) {
            Log.d("HabitsView", "clicked color = $it")
        }
    }
}

fun colors(): List<Color> {
    return listOf(
        Color(0xFFD32F2E),
        Color(0xFFE64A19),
        Color(0xFFF67C01),
        Color(0xFFFF8E01),
        Color(0xFF398E3D),
        Color(0xFF7DB343),
        Color(0xFFB0B42B),
        Color(0xFFF9A825),
        Color(0xFF00887A),
        Color(0xFF00ACC2),
        Color(0xFF039BE6),
        defaultColor,
        Color(0xFFD61B60),
        Color(0xFF8E24AA),
        Color(0xFF5D35B0),
        Color(0xFF303E9F),
        Color(0xFF5D4038),
        Color(0xFF424242),
        Color(0xFF757575),
        Color(0xFF9E9E9E)
    )
}

val defaultColor = Color(0xFF1976D3)