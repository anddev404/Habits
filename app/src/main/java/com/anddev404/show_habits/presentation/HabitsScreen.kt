package com.anddev404.show_habits.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.anddev404.navigation.Screen
import com.anddev404.show_habits.components.main_top_bar.MainTopBar
import com.anddev404.show_habits.presentation.habits_view.HabitsEmptyView
import com.anddev404.show_habits.presentation.habits_view.HabitsView
import com.anddev404.show_habits.presentation.habits_view.events.HabitsViewRowEvent
import com.anddev404.show_habits.presentation.habits_view.states.HabitsViewItemState
import com.anddev404.show_habits.presentation.main_top_bar.MainTopBarEvents

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HabitsScreen(navController: NavController, viewModel: HabitsViewModel = hiltViewModel()) {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        MainTopBar() {
            when (it) {
                is MainTopBarEvents.OnAddHabitClick -> {
                    navController.navigate(Screen.CreateHabitScreen(it.event.contentId))
                }
            }
        }
    }) { innerPadding ->

        val habitsState by viewModel.habitsView.collectAsState()

        if (habitsState.isEmpty()) {
            HabitsEmptyView(Modifier.padding(innerPadding))
            return@Scaffold
        }

        HabitsView(
            Modifier.padding(innerPadding),
            headerState = viewModel.header,
            habitsStates = habitsState
        ) { event ->
            when (event) {
                is HabitsViewRowEvent.OnItemClick -> {

                    when (event.item) {
                        is HabitsViewItemState.Value -> TODO()

                        is HabitsViewItemState.YesOrNo -> {
                            viewModel.updateItem(event.item.copy(isChecked = !event.item.isChecked))
                        }
                    }
                }

                is HabitsViewRowEvent.OnRowClick -> TODO()
                is HabitsViewRowEvent.OnRowLongClick -> TODO()
            }
        }
    }
}