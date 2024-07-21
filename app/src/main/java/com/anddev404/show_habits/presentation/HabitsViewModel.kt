package com.anddev404.show_habits.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anddev404.core.data.local.entity.HabitEntity
import com.anddev404.core.data.local.entity.ItemEntity
import com.anddev404.core.domain.repository.HabitRepository
import com.anddev404.show_habits.domain.DateGenerator.getCustomDatesFromToday
import com.anddev404.show_habits.domain.model.DayOfWeek
import com.anddev404.show_habits.presentation.habits_view.states.HabitsViewHeaderItemState
import com.anddev404.show_habits.presentation.habits_view.states.HabitsViewItemState
import com.anddev404.show_habits.presentation.habits_view.states.HabitsViewRowState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class HabitsViewModel @Inject constructor(
    private val repository: HabitRepository,
    private val dayOfWeek: DayOfWeek
) : ViewModel() {

    private val _habitState = MutableStateFlow(listOf<HabitEntity>())
    private val _itemState = MutableStateFlow(listOf<ItemEntity>())

    private val _habitsView = MutableStateFlow(listOf<HabitsViewRowState>())
    val habitsView = _habitsView.asStateFlow()
    var header = listOf<HabitsViewHeaderItemState>()

    init {
        header = getCustomDatesFromToday(30).map {
            HabitsViewHeaderItemState(
                dayOfWeek.getDayOfWeek(it.dayOfWeek), it.day, it.month, it.year
            )
        }

        getHabits()
        getItems()

        _habitState.combine(_itemState) { habits, allItems ->
            _habitsView.value = habits.map { habit ->
                val items = arrayListOf<HabitsViewItemState>()
                val filteredItems = allItems.filter { it.habitId == habit.id }

                header.forEach { header ->

                    val item = when (habit.habitType) {
                        1 -> HabitsViewItemState.YesOrNo(
                            0,
                            habit.id,
                            false,
                            Color(habit.color),
                            header.getTimeInMilliseconds()
                        )

                        2 -> HabitsViewItemState.Value(
                            0,
                            habit.id,
                            "kg",
                            10.0,
                            Color(habit.color),
                            header.getTimeInMilliseconds()
                        )

                        else -> {
                            HabitsViewItemState.YesOrNo(
                                0,
                                habit.id,
                                false,
                                Color(habit.color),
                                header.getTimeInMilliseconds()
                            )
                        }
                    }
                    items.add(item)
                }

                for (i in items) {
                    for (f in filteredItems) {

                        when (i) {
                            is HabitsViewItemState.Value -> {
                                if (i.date == f.date) {
                                    i.date = f.date
                                    i.id = f.id
                                    i.value = f.value
                                    i.unit = habit.unit
                                }
                            }

                            is HabitsViewItemState.YesOrNo -> {
                                if (i.date == f.date) {
                                    i.date = f.date
                                    i.id = f.id
                                    i.isChecked = f.isChecked
                                }
                            }
                        }
                    }
                }

                HabitsViewRowState(
                    name = habit.name, color = Color(habit.color), itemList = items
                )
            }
        }.launchIn(viewModelScope)
    }

    private fun getHabits() {

        viewModelScope.launch {
            launch {
                repository.getAllHabits()
                    .collect {
                        _habitState.value = it
                    }
            }
        }
    }

    fun updateItem(item: HabitsViewItemState) {

        val entity = when (item) {
            is HabitsViewItemState.Value -> ItemEntity(
                item.date,
                false,
                item.value,
                item.habitId,
                item.id
            )

            is HabitsViewItemState.YesOrNo -> ItemEntity(
                item.date,
                item.isChecked,
                0.0,
                item.habitId,
                item.id
            )
        }
        viewModelScope.launch {
            repository.insertItem(entity)
        }
    }

    private fun getItems() {
        viewModelScope.launch {
            if (header.isEmpty()) return@launch

            repository.getItemsAfterDate(header.last().getTimeInMilliseconds()).collect() {
                _itemState.value = _itemState.value.toMutableList().apply { addAll(it) }
            }
        }
    }
}