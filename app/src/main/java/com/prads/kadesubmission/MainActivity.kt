package com.prads.kadesubmission

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prads.kadesubmission.data.League
import com.prads.kadesubmission.data.League.Companion.LEAGUE_ID
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var leagues:List<League>

    lateinit var rvListLeague:RecyclerView

    private lateinit var leagueViewModel:LeagueViewModel

    lateinit var leagueAdapter: LeagueAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var mainUI = MainActivityUI()
        mainUI.setContentView(this)

        leagueViewModel = ViewModelProviders.of(this,viewModelFactory).get(LeagueViewModel::class.java)

        leagueAdapter = LeagueAdapter {
            Intent(this, LeagueDetailActivity::class.java).run {
                this.putExtra(LEAGUE_ID, it.id)
                startActivity(this)
            }
        }

        leagueViewModel.loadLeagues().observe(this, Observer {
            leagueAdapter.addData(it)
        })

        rvListLeague = mainUI.rvLeague

        rvListLeague.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = leagueAdapter
        }


    }


}
