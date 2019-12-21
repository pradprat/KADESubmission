package com.prads.kadesubmission.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.Event
import com.prads.kadesubmission.data.LeagueDummy
import com.prads.kadesubmission.ui.layout.EventDetailActivityUI
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.setContentView
import javax.inject.Inject


class EventDetailActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var teamViewModel: TeamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventDetailActivityUI().setContentView(this)

        var event : Event = intent.getParcelableExtra("TAG_EVENT")

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

    }
}
