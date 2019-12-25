package com.prads.kadesubmission.data.source.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class DatabaseHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "FavoriteEvent.db", null, 1) {
    companion object {
        private var instance: DatabaseHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): DatabaseHelper {
            if (instance == null) {
                instance = DatabaseHelper(ctx.applicationContext)
            }
            return instance as DatabaseHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable(EventFavorite.TABLE, true,
            EventFavorite.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            EventFavorite.dateEvent to TEXT,
            EventFavorite.dateEventLocal to TEXT,
            EventFavorite.idAwayTeam to TEXT,
            EventFavorite.idEvent to TEXT,
            EventFavorite.idHomeTeam to TEXT,
            EventFavorite.idLeague to TEXT,
            EventFavorite.idSoccerXML to TEXT,
            EventFavorite.intAwayScore to TEXT,
            EventFavorite.intAwayShots to TEXT,
            EventFavorite.intHomeScore to TEXT,
            EventFavorite.intHomeShots to TEXT,
            EventFavorite.intRound to TEXT,
            EventFavorite.intSpectators to TEXT,
            EventFavorite.strAwayFormation to TEXT,
            EventFavorite.strAwayGoalDetails to TEXT,
            EventFavorite.strAwayLineupDefense to TEXT,
            EventFavorite.strAwayLineupForward to TEXT,
            EventFavorite.strAwayLineupGoalkeeper to TEXT,
            EventFavorite.strAwayLineupMidfield to TEXT,
            EventFavorite.strAwayLineupSubstitutes to TEXT,
            EventFavorite.strAwayRedCards to TEXT,
            EventFavorite.strAwayTeam to TEXT,
            EventFavorite.strAwayYellowCards to TEXT,
            EventFavorite.strBanner to TEXT,
            EventFavorite.strCircuit to TEXT,
            EventFavorite.strCity to TEXT,
            EventFavorite.strCountry to TEXT,
            EventFavorite.strDate to TEXT,
            EventFavorite.strDescriptionEN to TEXT,
            EventFavorite.strEvent to TEXT,
            EventFavorite.strEventAlternate to TEXT,
            EventFavorite.strFanart to TEXT,
            EventFavorite.strFilename to TEXT,
            EventFavorite.strHomeFormation to TEXT,
            EventFavorite.strHomeGoalDetails to TEXT,
            EventFavorite.strHomeLineupDefense to TEXT,
            EventFavorite.strHomeLineupForward to TEXT,
            EventFavorite.strHomeLineupGoalkeeper to TEXT,
            EventFavorite.strHomeLineupMidfield to TEXT,
            EventFavorite.strHomeLineupSubstitutes to TEXT,
            EventFavorite.strHomeRedCards to TEXT,
            EventFavorite.strHomeTeam to TEXT,
            EventFavorite.strHomeYellowCards to TEXT,
            EventFavorite.strLeague to TEXT,
            EventFavorite.strLocked to TEXT,
            EventFavorite.strMap to TEXT,
            EventFavorite.strPoster to TEXT,
            EventFavorite.strResult to TEXT,
            EventFavorite.strSeason to TEXT,
            EventFavorite.strSport to TEXT,
            EventFavorite.strTVStation to TEXT,
            EventFavorite.strThumb to TEXT,
            EventFavorite.strTime to TEXT,
            EventFavorite.strTimeLocal to TEXT,
            EventFavorite.strTweet1 to TEXT,
            EventFavorite.strTweet2 to TEXT,
            EventFavorite.strTweet3 to TEXT,
            EventFavorite.strVideo to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable(EventFavorite.TABLE, true)
    }
}

// Access property for Context
val Context.database: DatabaseHelper
    get() = DatabaseHelper.getInstance(applicationContext)