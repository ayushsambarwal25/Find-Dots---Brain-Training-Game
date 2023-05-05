package com.tankarsolutions.finddotsbraintraininggame.di

import com.tankarsolutions.finddotsbraintraininggame.repo.GameRepository
import org.koin.dsl.module

val repoModule = module {
    single { GameRepository(get()) }
}