package com.prads.kadesubmission.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.model.Team
import com.prads.kadesubmission.ui.adapter.TeamSectionsPagerAdapter
import com.prads.kadesubmission.ui.layout.TeamDetailActivityUI
import com.prads.kadesubmission.ui.viewmodel.TeamViewModel
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.setContentView
import javax.inject.Inject

class TeamDetailActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var teamViewModel: TeamViewModel
    var isFavorite = false
    lateinit var team: Team

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TeamDetailActivityUI().setContentView(this)

        team = intent.getParcelableExtra("TAG_TEAM")

        teamViewModel = ViewModelProviders.of(this, viewModelFactory).get(TeamViewModel::class.java)

        supportActionBar?.title = team.strTeam
        Glide.with(this).load(team.strTeamBadge).into(findViewById(R.id.iv_team_detail_poster))
        findViewById<TextView>(R.id.tv_team_detail_description).text =
            team.strDescriptionEN?.substringBefore("\n")


        val sectionsPagerAdapter =
            TeamSectionsPagerAdapter(
                this,
                supportFragmentManager,
                team
            )
        val viewPager: ViewPager = this.findViewById(R.id.team_view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = this.findViewById(R.id.team_tabs)
        tabs.setupWithViewPager(viewPager)

        team.idTeam?.let { favoriteState(it) }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.favorite_menu, menu)
        if (menu != null) {
            setFavorite(menu.findItem(R.id.btn_favorite))
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.btn_favorite) {
            if (isFavorite) {
                team.idTeam?.let {
                    deleteFromFavorite()
                    isFavorite = false
                    setFavorite(item)
                }
            } else {
                team.idTeam?.let {
                    addToFavorite()
                    isFavorite = true
                    setFavorite(item)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun setFavorite(menuItem: MenuItem) {
        if (isFavorite)
            menuItem.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        else
            menuItem.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_border)
    }

    private fun favoriteState(eventId: String) {
        teamViewModel.isFavoriteTeam(applicationContext, eventId).observe(this, Observer {
            isFavorite = it
        })
    }

    private fun addToFavorite() {
        teamViewModel.addFavoriteTeam(applicationContext, team).observe(this, Observer {
            //            isFavorite = it
            Log.d("---database add " + it.toString(), team.strTeam.toString())
        })
    }

    private fun deleteFromFavorite() {
        teamViewModel.deleteFavoriteTeam(applicationContext, team).observe(this, Observer {
            //            isFavorite = it
            Log.d("---database delete " + it.toString(), team.strTeam.toString())
        })
    }
}
