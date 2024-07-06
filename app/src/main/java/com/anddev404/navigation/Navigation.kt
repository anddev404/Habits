package com.anddev404.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anddev404.create_habit.presentation.CreateHabitScreen
import com.anddev404.show_habits.presentation.HabitsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.HabitsScreen.route
    ) {
        composable(route = Screen.HabitsScreen.route) {
            HabitsScreen(navController = navController)
        }
        composable(route = Screen.CreateHabitScreen.route) {
            CreateHabitScreen()
        }

    }
}
