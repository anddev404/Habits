package com.anddev404.navigation

sealed class Screen(val route: String) {
    data object HabitsScreen : Screen("habit_screen")
    data object CreateHabitScreen : Screen("create_screen")
    data object StatsScreen : Screen("stats_screen")

    data object CreateHabitYesOrNoContent : Screen("create_habit_yes_or_no_content")
    data object CreateHabitMeasurableContent : Screen("create_habit_measurable_content")

}
