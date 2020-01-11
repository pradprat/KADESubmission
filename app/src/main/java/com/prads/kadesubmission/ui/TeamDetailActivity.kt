package com.prads.kadesubmission.ui

import android.os.Bundle
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.model.Team
import com.prads.kadesubmission.ui.adapter.TeamSectionsPagerAdapter
import com.prads.kadesubmission.ui.layout.TeamDetailActivityUI
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.setContentView

class TeamDetailActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TeamDetailActivityUI().setContentView(this)

        val team: Team = intent.getParcelableExtra("TAG_TEAM")

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
    }
}
