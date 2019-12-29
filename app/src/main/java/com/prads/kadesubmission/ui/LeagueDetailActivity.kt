package com.prads.kadesubmission.ui

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.model.LeagueDummy
import com.prads.kadesubmission.ui.adapter.SectionsPagerAdapter
import com.prads.kadesubmission.ui.layout.LeagueDetailActivityUI
import com.prads.kadesubmission.ui.viewmodel.LeagueViewModel
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


        val sectionsPagerAdapter =
            SectionsPagerAdapter(
                this,
                supportFragmentManager,
                league
            )
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter


        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.league_detail_menu, menu)

        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchItem = menu?.findItem(R.id.league_detail_search)
        val searchView = searchItem?.actionView as androidx.appcompat.widget.SearchView

        searchView.setSearchableInfo(manager.getSearchableInfo(componentName))

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                searchView.clearFocus()
                Toast.makeText(applicationContext,query,Toast.LENGTH_SHORT).show()

                Intent(applicationContext,
                    SearchEventActivity::class.java).run {
                    putExtra("TAG_LEAGUE_SEARCH",query)
                    startActivity(this)
                }

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
        return true
    }





}