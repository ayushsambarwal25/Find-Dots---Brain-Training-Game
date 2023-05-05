package com.tankarsolutions.finddotsbraintraininggame.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tankarsolutions.finddotsbraintraininggame.dao.GameDao
import com.tankarsolutions.finddotsbraintraininggame.entity.GameDB

@Database(entities = [GameDB::class], version = 1, exportSchema = false)
abstract class GameRoomDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}
