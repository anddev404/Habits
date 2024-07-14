package com.anddev404.create_habit.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anddev404.core.data.local.entity.HabitEntity
import com.anddev404.core.domain.repository.HabitRepository
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

    private val _habitEntity = MutableStateFlow(HabitEntity())
    val habitEntity = _habitEntity.asStateFlow()

    fun getHabitById(id: Int) {
        viewModelScope.launch {
            repository.getHabitById(id)
                .collect { habit ->
                    habit?.let {
                        _habitEntity.value = habit
                        _processState.value = CreateHabitState.HabitEditing
                        return@collect
                    }
                    _habitEntity.value = HabitEntity()
                    _processState.value = CreateHabitState.HabitDoesNotExist
                }
        }
    }
}