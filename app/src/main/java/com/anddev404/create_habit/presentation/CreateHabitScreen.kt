package com.anddev404.create_habit.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CreateHabitScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Text(modifier = Modifier.padding(innerPadding), text = "Create ... ")
    }
}