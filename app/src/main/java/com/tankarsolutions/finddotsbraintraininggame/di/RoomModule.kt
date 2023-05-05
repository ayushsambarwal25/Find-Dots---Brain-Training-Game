package com.tankarsolutions.finddotsbraintraininggame.di

import androidx.room.Room
import com.tankarsolutions.finddotsbraintraininggame.room.GameRoomDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomDBModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            GameRoomDatabase::class.java,
            "find_dots_database"
        ).fallbackToDestructiveMigration().build()
    }
    single { get<GameRoomDatabase>().gameDao() }
}

