package com.anddev404.create_habit.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.anddev404.R
import com.anddev404.core.presentation.components.ColorPaletteDialog
import com.anddev404.core.presentation.components.ErrorHandlingOutlinedTextField
import com.anddev404.core.presentation.components.LoadingScreen
import com.anddev404.create_habit.presentation.create_habit_top_bar.CreateHabitTopBar
import com.anddev404.navigation.CreateHabitNavigation
import com.anddev404.navigation.Screen
import com.anddev404.show_habits.presentation.main_top_bar.dialogs.MainTopBarDialogEvent
import com.anddev404.ui.theme.InactiveLightColor
import com.anddev404.ui.theme.LocalSpacing

@Composable
fun CreateHabitScreen(
    state: MainTopBarDialogEvent = MainTopBarDialogEvent.OnAddHabitYesOrNoClick,
    id: Int = 0,
    viewModel: CreateHabitViewModel = hiltViewModel(),
    onBackClick: () -> Unit = {}
) {
    if (id > 0) viewModel.getHabitById(id) else viewModel.createNewHabit(state)

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        CreateHabitTopBar(onBackClick = { onBackClick() }) {
            viewModel.insertHabit {
                onBackClick()
            }
        }
    }) { innerPadding ->

        val viewState by viewModel.processState.collectAsState()
        when (viewState) {
            CreateHabitState.HabitLoading -> {
                LoadingScreen(Modifier.padding(innerPadding))
                return@Scaffold
            }

            else -> {}
        }

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding()
                .padding(LocalSpacing.current.spaceSmall)
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Max)
                ) {
                    val habitState by viewModel.habitState.collectAsState()

                    ErrorHandlingOutlinedTextField(
                        Modifier.weight(1.0f),
                        habitState.name,
                        {
                            viewModel.updateHabitState(
                                habitState.copy(
                                    name = it, isValidName = true
                                )
                            )
                        },
                        stringResource(id = R.string.name),
                        stringResource(id = R.string.name_example),
                        isValid = habitState.isValidName,
                        errorText = stringResource(id = R.string.empty_field)
                    )

                    Spacer(modifier = Modifier.width(LocalSpacing.current.spaceSmall))
                    Box(
                        modifier = Modifier.size(64.dp)
                    ) {
                        OutlinedTextField(modifier = Modifier.fillMaxSize(),
                            value = " ",
                            onValueChange = {

                            },
                            label = { Text(text = stringResource(id = R.string.color)) },
                            readOnly = true
                        )
                        var showColorPalette by remember {
                            mutableStateOf(false)
                        }
                        if (showColorPalette) ColorPaletteDialog(habitState.color) {
                            showColorPalette = false
                            if (it == 0) return@ColorPaletteDialog
                            viewModel.updateHabitState(habitState.copy(color = it))
                        }
                        OutlinedTextField(modifier = Modifier.fillMaxSize(),
                            value = " ",
                            onValueChange = {},
                            label = { Text(text = stringResource(id = R.string.color)) },
                            readOnly = true
                        )
                        Spacer(modifier = Modifier
                            .clickable {
                                showColorPalette = true
                            }
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(Color(habitState.color))
                            .border(1.dp, InactiveLightColor))
                    }
                }

                when (state) {
                    MainTopBarDialogEvent.OnAddHabitMeasurableClick -> CreateHabitNavigation(Screen.CreateHabitMeasurableContent.route)
                    MainTopBarDialogEvent.OnAddHabitYesOrNoClick -> CreateHabitNavigation(Screen.CreateHabitYesOrNoContent.route)
                }
                Spacer(modifier = Modifier.height(LocalSpacing.current.spaceMedium))

                OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                    value = stringResource(id = R.string.turned_off),
                    enabled = false,
                    onValueChange = {},
                    label = { Text(text = stringResource(id = R.string.reminder)) },
                    trailingIcon = {
                        Icon(imageVector = Icons.Default.ArrowDropDown, "")
                    })
                Spacer(modifier = Modifier.height(LocalSpacing.current.spaceMedium))

                OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                    value = " ",
                    enabled = false,
                    onValueChange = {},
                    label = { Text(text = stringResource(id = R.string.notes)) })
                Spacer(modifier = Modifier.height(LocalSpacing.current.spaceMedium))
            }
        }
    }
}



