package com.anddev404.show_habits.presentation

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.anddev404.navigation.Screen
import com.anddev404.show_habits.presentation.main_top_bar.MainTopBar
import com.anddev404.show_habits.presentation.habits_view.HabitsEmptyView
import com.anddev404.show_habits.presentation.habits_view.HabitsView
import com.anddev404.show_habits.presentation.habits_view.events.HabitsViewRowEvent
import com.anddev404.show_habits.presentation.habits_view.states.HabitsViewItemState
import com.anddev404.show_habits.presentation.main_top_bar.MainTopBarEvents

@Composable
fun HabitsScreen(navController: NavController, viewModel: HabitsViewModel = hiltViewModel()) {
    val context = LocalContext.current

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
                        is HabitsViewItemState.Value -> showNotAvailableYetToast(context)

                        is HabitsViewItemState.YesOrNo -> {
                            viewModel.updateItem(event.item.copy(isChecked = !event.item.isChecked))
                        }
                    }
                }

                is HabitsViewRowEvent.OnRowClick -> showNotAvailableYetToast(context)
                is HabitsViewRowEvent.OnRowLongClick -> showNotAvailableYetToast(context)
            }
        }
    }
}

private fun showNotAvailableYetToast(context: Context) {
    Toast.makeText(context, "Not available yet!", Toast.LENGTH_SHORT).show();
}