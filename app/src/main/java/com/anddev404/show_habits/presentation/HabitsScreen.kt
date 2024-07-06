package com.anddev404.show_habits.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.anddev404.show_habits.components.main_top_bar.MainTopBar

@Composable
fun HabitsScreen(navController: NavController) {

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            MainTopBar()
        }) { innerPadding ->
        Text(modifier = Modifier.padding(innerPadding), text = "Habits ... ")
    }
}