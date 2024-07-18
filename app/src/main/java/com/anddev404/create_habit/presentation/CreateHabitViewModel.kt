package com.anddev404.create_habit.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anddev404.core.data.mapper.toHabit
import com.anddev404.core.data.mapper.toHabitEntity
import com.anddev404.core.domain.repository.HabitRepository
import com.anddev404.show_habits.domain.model.Habit
import com.anddev404.show_habits.presentation.main_top_bar.dialogs.MainTopBarDialogEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateHabitViewModel @Inject constructor(private val repository: HabitRepository) :
    ViewModel() {

    private val _processState: MutableStateFlow<CreateHabitState> =
        MutableStateFlow(CreateHabitState.HabitLoading)
    val processState = _processState.asStateFlow()

    private val _habitState = MutableStateFlow(Habit())
    val habitState = _habitState.asStateFlow()

    fun getHabitById(id: Int) {
        viewModelScope.launch {
            repository.getHabitById(id)?.let {
                _habitState.value = it.toHabit()
                _processState.value = CreateHabitState.HabitEditing
                return@launch
            }
            _processState.value = CreateHabitState.HabitDoesNotExist
        }
    }

    fun createNewHabit(state: MainTopBarDialogEvent) {
        _habitState.value = _habitState.value.copy(habitType = state.contentId)
        _processState.value = CreateHabitState.HabitCreating
    }

    fun updateHabitState(habit: Habit) {
        _habitState.value = habit
    }

    fun insertHabit(success: () -> Unit = {}) {
        viewModelScope.launch {
            if (_habitState.value.name.text.isEmpty()) {
                _habitState.value = _habitState.value.copy(isValidName = false)
            } else {
                repository.insertHabit(_habitState.value.toHabitEntity())
                success()
            }
        }
    }
}