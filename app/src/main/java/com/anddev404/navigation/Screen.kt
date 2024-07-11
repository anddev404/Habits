package com.anddev404.navigation

import kotlinx.serialization.Serializable

sealed class Screen(val route: String) {
    data object HabitsScreen : Screen("habit_screen")

    @Serializable
    data class CreateHabitScreen(val contentId: Int)
    data object StatsScreen : Screen("stats_screen")
    data object CreateHabitYesOrNoContent : Screen("create_habit_yes_or_no_content")
    data object CreateHabitMeasurableContent : Screen("create_habit_measurable_content")

}
