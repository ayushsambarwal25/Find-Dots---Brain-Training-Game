package com.tankarsolutions.finddotsbraintraininggame.entity

data class MasterDashboardDB(
    val gameType1DB: GameType1DB,
    val gameType2DB: GameType2DB,
    val gameType3DB: GameType3DB,
    val gameType4DB: GameType4DB
) {
    data class GameType1DB(val gamePlayed: Int = 0, val totalAccuracy: Int = 0, val time: Long = 0)
    data class GameType2DB(val gamePlayed: Int = 0, val totalAccuracy: Int = 0, val time: Long = 0)
    data class GameType3DB(val gamePlayed: Int = 0, val totalAccuracy: Int = 0, val time: Long = 0)
    data class GameType4DB(val gamePlayed: Int = 0, val totalAccuracy: Int = 0, val time: Long = 0)
}

