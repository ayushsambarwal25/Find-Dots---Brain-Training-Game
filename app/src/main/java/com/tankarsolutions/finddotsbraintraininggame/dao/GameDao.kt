package com.tankarsolutions.finddotsbraintraininggame.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tankarsolutions.finddotsbraintraininggame.entity.GameDB

@Dao
interface GameDao {
    @Query("SELECT * FROM gameDB ORDER BY id DESC")
    fun getAllData(): LiveData<List<GameDB>>

    @Insert
    fun insertData(gameDB: GameDB)

}