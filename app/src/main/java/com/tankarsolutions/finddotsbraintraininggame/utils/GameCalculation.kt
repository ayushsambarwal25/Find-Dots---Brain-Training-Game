package com.tankarsolutions.finddotsbraintraininggame.utils

import com.tankarsolutions.finddotsbraintraininggame.entity.GameDB
import com.tankarsolutions.finddotsbraintraininggame.entity.MasterDashboardDB

object GameCalculation {
    fun calculateForDashBoard(masterList: List<GameDB>?): MasterDashboardDB {
        if (masterList.isNullOrEmpty()) {
            return MasterDashboardDB(
                MasterDashboardDB.GameType1DB(),
                MasterDashboardDB.GameType2DB(),
                MasterDashboardDB.GameType3DB(),
                MasterDashboardDB.GameType4DB()
            )
        } else {
            val game1 = masterList.filter { it.game_type == 1 }
            val game2 = masterList.filter { it.game_type == 2 }
            val game3 = masterList.filter { it.game_type == 3 }
            val game4 = masterList.filter { it.game_type == 4 }

            val gamePlayed1 = game1.size
            val gamePlayed2 = game2.size
            val gamePlayed3 = game3.size
            val gamePlayed4 = game4.size

            val type1Accuracy = if (game1.isNotEmpty()) game1.sumBy {
                it.accuracy
            } / game1.size
            else
                0

            val type2Accuracy = if (game2.isNotEmpty()) game2.sumBy {
                it.accuracy
            } / game2.size
            else
                0

            val type3Accuracy = if (game3.isNotEmpty()) game3.sumBy {
                it.accuracy
            } / game3.size
            else
                0

            val type4Accuracy = if (game4.isNotEmpty()) game4.sumBy {
                it.accuracy
            } / game4.size
            else
                0

            val time1 = game1.map {
                it.time
            }.sum()

            val time2 = game2.map {
                it.time
            }.sum()

            val time3 = game3.map {
                it.time
            }.sum()

            val time4 = game4.map {
                it.time
            }.sum()

            return MasterDashboardDB(
                MasterDashboardDB.GameType1DB(gamePlayed1, type1Accuracy, time1),
                MasterDashboardDB.GameType2DB(gamePlayed2, type2Accuracy, time2),
                MasterDashboardDB.GameType3DB(gamePlayed3, type3Accuracy, time3),
                MasterDashboardDB.GameType4DB(gamePlayed4, type4Accuracy, time4)
            )
        }
    }
}