package com.prads.kadesubmission

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.prads.kadesubmission.ui.adapter.TeamSectionsPagerAdapter
import com.prads.kadesubmission.ui.layout.TeamDetailActivityUI
import com.prads.kadesubmission.utils.DummyData
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.setContentView

class TeamDetailActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TeamDetailActivityUI().setContentView(this)

        val sectionsPagerAdapter =
            TeamSectionsPagerAdapter(
                this,
                supportFragmentManager,
                DummyData().getLeagues()?.last()!!
            )
        val viewPager: ViewPager = this.findViewById(R.id.team_view_pager)
        viewPager.adapter = sectionsPagerAdapter


        val tabs: TabLayout = this.findViewById(R.id.team_tabs)
        tabs.setupWithViewPager(viewPager)
    }
}
