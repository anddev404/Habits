package com.anddev404.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.anddev404.create_habit.presentation.CreateHabitScreen
import com.anddev404.show_habits.presentation.HabitsScreen
import com.anddev404.show_habits.presentation.main_top_bar.dialogs.MainTopBarDialogEvent

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.HabitsScreen.route
    ) {
        composable(route = Screen.HabitsScreen.route) {
            HabitsScreen(navController = navController)
        }
        composable<Screen.CreateHabitScreen> {
            val args = it.toRoute<Screen.CreateHabitScreen>()
            CreateHabitScreen(MainTopBarDialogEvent.getByContentId(args.contentId)) {
                navController.navigateUp()
            }
        }

    }
}
