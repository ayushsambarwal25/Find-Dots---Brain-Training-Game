package com.tankarsolutions.finddotsbraintraininggame.repo

import com.tankarsolutions.finddotsbraintraininggame.dao.GameDao
import com.tankarsolutions.finddotsbraintraininggame.entity.GameDB

class GameRepository(private val dao: GameDao) {

    fun getAllData() = dao.getAllData()

    fun insertData(gameDB: GameDB) {
        dao.insertData(gameDB)
    }

}