package com.anddev404.show_habits.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.anddev404.navigation.Screen
import com.anddev404.show_habits.components.main_top_bar.MainTopBar
import com.anddev404.show_habits.presentation.main_top_bar.MainTopBarEvents

@Composable
fun HabitsScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            MainTopBar() {
                when (it) {
                    is MainTopBarEvents.OnAddHabitClick -> {
                        navController.navigate(Screen.CreateHabitScreen(it.event.contentId))
                    }
                }
            }
        }) { innerPadding ->
        Column {
            Text(modifier = Modifier.padding(innerPadding), text = "Habits ... ")
        }
    }
}