package com.anddev404.create_habit.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.anddev404.habits.components.habits_view.HabitsView
import com.anddev404.habits.components.main_top_bar.MainTopBar

@Composable
fun CreateHabitScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Text(modifier = Modifier.padding(innerPadding), text = "Create ... ")
    }
}