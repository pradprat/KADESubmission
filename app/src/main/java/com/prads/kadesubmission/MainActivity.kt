package com.prads.kadesubmission

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prads.kadesubmission.data.LeagueDummy
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() , AnkoLogger{


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var leagueDummies:List<LeagueDummy>

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
                this.putExtra("TAG_LEAGUE", it)
                toast("kamu memilih "+it.name)
                startActivity(this)
            }
        }

        leagueViewModel.loadLeagues().observe(this, Observer {
            leagueAdapter.addData(it)
            info("data observed")
        })

        rvListLeague = mainUI.rvLeague

        rvListLeague.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = leagueAdapter
            info("recyclerview created")
        }


    }


}
