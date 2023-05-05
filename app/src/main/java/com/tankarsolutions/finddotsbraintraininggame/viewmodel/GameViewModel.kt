package com.tankarsolutions.finddotsbraintraininggame.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tankarsolutions.finddotsbraintraininggame.entity.GameDB
import com.tankarsolutions.finddotsbraintraininggame.repo.GameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameViewModel(private val gameRepository: GameRepository) : ViewModel() {


    fun insertData(gameDB: GameDB) = viewModelScope.launch(Dispatchers.IO) {
        gameRepository.insertData(gameDB)
    }

    fun getAllData() = gameRepository.getAllData()

}