package com.prads.kadesubmission.ui

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.Event
import com.prads.kadesubmission.data.LeagueDummy
import com.prads.kadesubmission.data.source.local.EventFavorite
import com.prads.kadesubmission.data.source.local.database
import com.prads.kadesubmission.ui.layout.EventDetailActivityUI
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.setContentView
import javax.inject.Inject


class EventDetailActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var teamViewModel: TeamViewModel

    var isFavorite = false

    lateinit var event:Event

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventDetailActivityUI().setContentView(this)

        event = intent.getParcelableExtra("TAG_EVENT")

        Log.d("---",event.toString())

        supportActionBar?.title = event.strEvent
        findViewById<TextView>(R.id.event_detail_home_score).text = event.intHomeScore
        findViewById<TextView>(R.id.event_detail_away_score).text = event.intAwayScore
        findViewById<TextView>(R.id.event_detail_home_name).text = event.strHomeTeam
        findViewById<TextView>(R.id.event_detail_away_name).text = event.strAwayTeam

        findViewById<TextView>(R.id.tv_event_detail_date).text = event.dateEvent
            findViewById<TextView>(R.id.tv_event_detail_time).text = event.strTime
            findViewById<TextView>(R.id.tv_event_detail_formation_home).text = event.strHomeFormation
            findViewById<TextView>(R.id.tv_event_detail_formation_away).text = event.strAwayFormation
            findViewById<TextView>(R.id.tv_event_detail_goals_home).text = event.strHomeGoalDetails?.replace(";","\n")
            findViewById<TextView>(R.id.tv_event_detail_goals_away).text = event.strAwayGoalDetails?.replace(";","\n")
            findViewById<TextView>(R.id.tv_event_detail_yellow_home).text = event.strHomeYellowCards?.replace(";","\n")
            findViewById<TextView>(R.id.tv_event_detail_yellow_away).text = event.strAwayYellowCards?.replace(";","\n")
            findViewById<TextView>(R.id.tv_event_detail_red_home).text = event.strHomeRedCards?.replace(";","\n")
            findViewById<TextView>(R.id.tv_event_detail_red_away).text = event.strAwayRedCards?.replace(";","\n")
            findViewById<TextView>(R.id.tv_event_detail_keeper_home).text = event.strHomeLineupGoalkeeper?.replace(";","\n")
            findViewById<TextView>(R.id.tv_event_detail_keeper_away).text = event.strAwayLineupGoalkeeper?.replace(";","\n")
            findViewById<TextView>(R.id.tv_event_detail_defenses_home).text = event.strHomeLineupDefense?.replace(";","\n")
            findViewById<TextView>(R.id.tv_event_detail_defenses_away).text = event.strAwayLineupDefense?.replace(";","\n")
            findViewById<TextView>(R.id.tv_event_detail_mid_home).text = event.strHomeLineupMidfield?.replace(";","\n")
            findViewById<TextView>(R.id.tv_event_detail_mid_away).text = event.strAwayLineupMidfield?.replace(";","\n")
            findViewById<TextView>(R.id.tv_event_detail_forwards_home).text = event.strHomeLineupForward?.replace(";","\n")
            findViewById<TextView>(R.id.tv_event_detail_forwards_away).text = event.strAwayLineupForward?.replace(";","\n")
            findViewById<TextView>(R.id.tv_event_detail_subst_home).text = event.strHomeLineupSubstitutes?.replace(";","\n")
            findViewById<TextView>(R.id.tv_event_detail_subst_away).text = event.strAwayLineupSubstitutes?.replace(";","\n")


        teamViewModel = ViewModelProviders.of(this,viewModelFactory).get(TeamViewModel::class.java)

        event.idHomeTeam?.let {
            teamViewModel.loadTeamById(it).observe(this, Observer {
                Glide.with(this).load(it.strTeamLogo).into(findViewById(R.id.event_detail_home_logo))
            })
        }
        event.idAwayTeam?.let {
            teamViewModel.loadTeamById(it).observe(this, Observer {
                Glide.with(this).load(it.strTeamLogo).into(findViewById(R.id.event_detail_away_logo))
            })
        }

        event.idEvent?.let { favoriteState(it) }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.event_detail_menu, menu)
        if (menu != null) {
            setFavorite(menu.findItem(R.id.event_detail_favorite))
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.event_detail_favorite){
            if (isFavorite){
                event.idEvent?.let {
                    removeFromFavorite()
                    isFavorite=false
                    setFavorite(item)
                }
            }else{
                event.idEvent?.let {
                    addToFavorite()
                    isFavorite=true
                    setFavorite(item)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun favoriteState(eventId:String){
        database.use {
            val result = select(EventFavorite.TABLE)
                .whereArgs("(idEvent = {id})",
                    "id" to eventId)
            val favorite = result.parseList(classParser<EventFavorite>())
            if (favorite.isNotEmpty()) isFavorite = true
        }
    }

    private fun addToFavorite(){
        try {
            database.use {
                insert(EventFavorite.TABLE,
                    EventFavorite.dateEvent to event.dateEvent,
                    EventFavorite.dateEventLocal to event.dateEventLocal,
                    EventFavorite.idAwayTeam to event.idAwayTeam,
                    EventFavorite.idEvent to event.idEvent,
                    EventFavorite.idHomeTeam to event.idHomeTeam,
                    EventFavorite.idLeague to event.idLeague,
                    EventFavorite.idSoccerXML to event.idSoccerXML,
                    EventFavorite.intAwayScore to event.intAwayScore,
                    EventFavorite.intAwayShots to event.intAwayShots,
                    EventFavorite.intHomeScore to event.intHomeScore,
                    EventFavorite.intHomeShots to event.intHomeShots,
                    EventFavorite.intRound to event.intRound,
                    EventFavorite.intSpectators to event.intSpectators,
                    EventFavorite.strAwayFormation to event.strAwayFormation,
                    EventFavorite.strAwayGoalDetails to event.strAwayGoalDetails,
                    EventFavorite.strAwayLineupDefense to event.strAwayLineupDefense,
                    EventFavorite.strAwayLineupForward to event.strAwayLineupForward,
                    EventFavorite.strAwayLineupGoalkeeper to event.strAwayLineupGoalkeeper,
                    EventFavorite.strAwayLineupMidfield to event.strAwayLineupMidfield,
                    EventFavorite.strAwayLineupSubstitutes to event.strAwayLineupSubstitutes,
                    EventFavorite.strAwayRedCards to event.strAwayRedCards,
                    EventFavorite.strAwayTeam to event.strAwayTeam,
                    EventFavorite.strAwayYellowCards to event.strAwayYellowCards,
                    EventFavorite.strBanner to event.strBanner,
                    EventFavorite.strCircuit to event.strCircuit,
                    EventFavorite.strCity to event.strCity,
                    EventFavorite.strCountry to event.strCountry,
                    EventFavorite.strDate to event.strDate,
                    EventFavorite.strDescriptionEN to event.strDescriptionEN,
                    EventFavorite.strEvent to event.strEvent,
                    EventFavorite.strEventAlternate to event.strEventAlternate,
                    EventFavorite.strFanart to event.strFanart,
                    EventFavorite.strFilename to event.strFilename,
                    EventFavorite.strHomeFormation to event.strHomeFormation,
                    EventFavorite.strHomeGoalDetails to event.strHomeGoalDetails,
                    EventFavorite.strHomeLineupDefense to event.strHomeLineupDefense,
                    EventFavorite.strHomeLineupForward to event.strHomeLineupForward,
                    EventFavorite.strHomeLineupGoalkeeper to event.strHomeLineupGoalkeeper,
                    EventFavorite.strHomeLineupMidfield to event.strHomeLineupMidfield,
                    EventFavorite.strHomeLineupSubstitutes to event.strHomeLineupSubstitutes,
                    EventFavorite.strHomeRedCards to event.strHomeRedCards,
                    EventFavorite.strHomeTeam to event.strHomeTeam,
                    EventFavorite.strHomeYellowCards to event.strHomeYellowCards,
                    EventFavorite.strLeague to event.strLeague,
                    EventFavorite.strLocked to event.strLocked,
                    EventFavorite.strMap to event.strMap,
                    EventFavorite.strPoster to event.strPoster,
                    EventFavorite.strResult to event.strResult,
                    EventFavorite.strSeason to event.strSeason,
                    EventFavorite.strSport to event.strSport,
                    EventFavorite.strTVStation to event.strTVStation,
                    EventFavorite.strThumb to event.strThumb,
                    EventFavorite.strTime to event.strTime,
                    EventFavorite.strTimeLocal to event.strTimeLocal,
                    EventFavorite.strTweet1 to event.strTweet1,
                    EventFavorite.strTweet2 to event.strTweet2,
                    EventFavorite.strTweet3 to event.strTweet3,
                    EventFavorite.strVideo to event.strVideo)
            }
            Log.d("---database",event.strEvent+" success Added")
//            swipeRefresh.snackbar("Added to favorite").show()
        } catch (e: SQLiteConstraintException){
            Log.d("---database",e.localizedMessage)

//            swipeRefresh.snackbar(e.localizedMessage).show()
        }
    }

    private fun removeFromFavorite(){
        val idEvent = ""+event.idEvent
        try {
            database.use {
                delete(EventFavorite.TABLE, "(idEvent = {id})",
                    "id" to idEvent)
            }
            Log.d("---database",idEvent+" success Deleted")

//            swipeRefresh.snackbar("Removed to favorite").show()
        } catch (e: SQLiteConstraintException){
            Log.d("---database",e.localizedMessage)
//            swipeRefresh.snackbar(e.localizedMessage).show()
        }
    }

    private fun setFavorite(menuItem: MenuItem) {
        if (isFavorite)
            menuItem.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        else
            menuItem.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_border)
    }
}
