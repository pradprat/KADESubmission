package com.prads.kadesubmission.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.LeagueDummy
import com.prads.kadesubmission.ui.layout.LeagueDetailActivityUI
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.setContentView
import javax.inject.Inject

class LeagueDetailActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var leagueViewModel: LeagueViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LeagueDetailActivityUI().setContentView(this)

        var league : LeagueDummy = intent.getParcelableExtra("TAG_LEAGUE")

        leagueViewModel = ViewModelProviders.of(this,viewModelFactory).get(LeagueViewModel::class.java)

        if (league.id != null) {
            leagueViewModel.loadLeagueById(league.id).observe(this, Observer {
                //                LOAD ALL
                supportActionBar?.title = it.strLeague
                Glide.with(this).load(it.strLogo).into(findViewById(R.id.iv_league_detail_poster))
                findViewById<TextView>(R.id.tv_league_detail_description).text = it.strDescriptionEN

                Log.d("---",it.toString())
            })
        }


        val sectionsPagerAdapter = SectionsPagerAdapter(
            this,
            supportFragmentManager,
            league
        )
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter


        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)


    }
}