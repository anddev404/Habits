package com.anddev404

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.anddev404.navigation.Navigation
import com.anddev404.ui.theme.HabbitsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.status_bar_color)
            window.navigationBarColor = getColor(R.color.navigation_bar_color)

            HabbitsTheme {
                Navigation()
            }
        }
    }
}