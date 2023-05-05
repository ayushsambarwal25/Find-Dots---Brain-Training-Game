package com.tankarsolutions.finddotsbraintraininggame.di

import com.tankarsolutions.finddotsbraintraininggame.viewmodel.GameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        GameViewModel(get())
    }
}