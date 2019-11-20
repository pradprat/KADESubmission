package com.prads.kadesubmission.ui.tabs

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.League
import com.prads.kadesubmission.data.LeagueDummy
import com.prads.kadesubmission.ui.LeagueViewModel
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
//                Log.d("---",it.toString())
            })
        }


        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager, league )
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter


        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)


    }
}