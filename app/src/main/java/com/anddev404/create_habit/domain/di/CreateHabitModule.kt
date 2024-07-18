package com.anddev404.create_habit.domain.di

import com.anddev404.core.domain.repository.HabitRepository
import com.anddev404.create_habit.domain.use_case.CreateHabitUseCases
import com.anddev404.create_habit.domain.use_case.GetHabit
import com.anddev404.create_habit.domain.use_case.InsertHabit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object CreateHabitModule {

    @Provides
    @ViewModelScoped
    fun provideCreateHabitUseCases(repository: HabitRepository): CreateHabitUseCases {
        return CreateHabitUseCases(InsertHabit(repository), GetHabit(repository))
    }
}