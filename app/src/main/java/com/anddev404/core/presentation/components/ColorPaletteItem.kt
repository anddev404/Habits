package com.anddev404.core.presentation.components

import android.util.Log
import android.widget.ImageButton
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anddev404.ui.theme.InactiveDarkColor
import com.anddev404.ui.theme.LocalSpacing

@Composable
fun ColorPaletteItem(
    modifier: Modifier = Modifier,
    isChecked: Boolean = false,
    color: Color,
    onClick: (Int) -> Unit = {}
) {
    Box(modifier, contentAlignment = Alignment.Center) {
        IconButton(
            modifier = Modifier
                .clip(CircleShape)
                .size(LocalSpacing.current.habitItemSize),
            onClick = { onClick(color.toArgb()) },
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = color,
                contentColor = InactiveDarkColor
            )
        ) {
            if (isChecked) {
                Icon(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(LocalSpacing.current.habitItemSizeSmall),
                    imageVector = Icons.Outlined.CheckCircle, contentDescription = ""
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ColorPaletteItemPreview() {
    ColorPaletteItem(Modifier.padding(10.dp), true, Color.Green)
}