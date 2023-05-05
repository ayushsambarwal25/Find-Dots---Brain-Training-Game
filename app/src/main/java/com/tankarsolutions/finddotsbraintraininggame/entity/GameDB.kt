package com.tankarsolutions.finddotsbraintraininggame.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gameDB")
data class GameDB(
    @ColumnInfo(name = "game_type")
    val game_type: Int,
    @ColumnInfo(name = "accuracy")
    val accuracy: Int,
    @ColumnInfo(name = "time")
    val time: Long
) {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}