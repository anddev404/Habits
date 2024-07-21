package com.anddev404.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.anddev404.core.data.local.HabitDatabase
import com.anddev404.core.data.repository.HabitRepositoryImpl
import com.anddev404.core.domain.repository.HabitRepository
import com.anddev404.show_habits.data.DayOfWeekImpl
import com.anddev404.show_habits.domain.model.DayOfWeek
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHabitDatabase(app: Application): HabitDatabase {
        return Room.databaseBuilder(
            app,
            HabitDatabase::class.java,
            "habit_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideHabitRepository(database: HabitDatabase): HabitRepository {
        return HabitRepositoryImpl(database)
    }

    @Provides
    @Singleton
    fun provideDayOfWeek(app: Application): DayOfWeek {
        return DayOfWeekImpl(app)
    }
}