package com.anddev404.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anddev404.create_habit.presentation.measurable_content.CreateHabitMeasurableContent
import com.anddev404.create_habit.presentation.yes_or_no_content.CreateHabitYesOrNoContent

@Composable
fun CreateHabitNavigation(startContentRoute: String) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startContentRoute
    ) {
        composable(Screen.CreateHabitYesOrNoContent.route) { CreateHabitYesOrNoContent() }
        composable(Screen.CreateHabitMeasurableContent.route) { CreateHabitMeasurableContent() }
    }
}