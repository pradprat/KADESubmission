package com.prads.kadesubmission.data.source.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.ManagedSQLiteOpenHelper
import org.jetbrains.anko.db.TEXT
import org.jetbrains.anko.db.createTable
import org.jetbrains.anko.db.dropTable

class DatabaseHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "Favorite.db", null, 1) {
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
        db.createTable(
            EventFavorite.TABLE, true,
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
        db.createTable(
            TeamFavorite.TABLE, true,
            TeamFavorite.idLeague to TEXT,
            TeamFavorite.idSoccerXML to TEXT,
            TeamFavorite.idTeam to TEXT,
            TeamFavorite.intFormedYear to TEXT,
            TeamFavorite.intLoved to TEXT,
            TeamFavorite.intStadiumCapacity to TEXT,
            TeamFavorite.strAlternate to TEXT,
            TeamFavorite.strCountry to TEXT,
            TeamFavorite.strDescriptionCN to TEXT,
            TeamFavorite.strDescriptionDE to TEXT,
            TeamFavorite.strDescriptionEN to TEXT,
            TeamFavorite.strDescriptionES to TEXT,
            TeamFavorite.strDescriptionFR to TEXT,
            TeamFavorite.strDescriptionHU to TEXT,
            TeamFavorite.strDescriptionIL to TEXT,
            TeamFavorite.strDescriptionIT to TEXT,
            TeamFavorite.strDescriptionJP to TEXT,
            TeamFavorite.strDescriptionNL to TEXT,
            TeamFavorite.strDescriptionNO to TEXT,
            TeamFavorite.strDescriptionPL to TEXT,
            TeamFavorite.strDescriptionPT to TEXT,
            TeamFavorite.strDescriptionRU to TEXT,
            TeamFavorite.strDescriptionSE to TEXT,
            TeamFavorite.strDivision to TEXT,
            TeamFavorite.strFacebook to TEXT,
            TeamFavorite.strGender to TEXT,
            TeamFavorite.strInstagram to TEXT,
            TeamFavorite.strKeywords to TEXT,
            TeamFavorite.strLeague to TEXT,
            TeamFavorite.strLocked to TEXT,
            TeamFavorite.strManager to TEXT,
            TeamFavorite.strRSS to TEXT,
            TeamFavorite.strSport to TEXT,
            TeamFavorite.strStadium to TEXT,
            TeamFavorite.strStadiumDescription to TEXT,
            TeamFavorite.strStadiumLocation to TEXT,
            TeamFavorite.strStadiumThumb to TEXT,
            TeamFavorite.strTeam to TEXT,
            TeamFavorite.strTeamBadge to TEXT,
            TeamFavorite.strTeamBanner to TEXT,
            TeamFavorite.strTeamFanart1 to TEXT,
            TeamFavorite.strTeamFanart2 to TEXT,
            TeamFavorite.strTeamFanart3 to TEXT,
            TeamFavorite.strTeamFanart4 to TEXT,
            TeamFavorite.strTeamJersey to TEXT,
            TeamFavorite.strTeamLogo to TEXT,
            TeamFavorite.strTeamShort to TEXT,
            TeamFavorite.strTwitter to TEXT,
            TeamFavorite.strWebsite to TEXT,
            TeamFavorite.strYoutube to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable(EventFavorite.TABLE, true)
        db.dropTable(TeamFavorite.TABLE, true)
    }
}

// Access property for Context
val Context.database: DatabaseHelper
    get() = DatabaseHelper.getInstance(applicationContext)