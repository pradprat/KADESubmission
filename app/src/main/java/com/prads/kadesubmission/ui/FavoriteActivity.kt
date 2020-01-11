package com.prads.kadesubmission.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.model.TeamDummy
import com.prads.kadesubmission.ui.adapter.EventAdapter
import com.prads.kadesubmission.ui.adapter.FavoriteSectionsPagerAdapter
import com.prads.kadesubmission.ui.layout.FavoriteActivityUI
import com.prads.kadesubmission.ui.viewmodel.EventViewModel
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.setContentView
import javax.inject.Inject

class FavoriteActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var eventViewModel: EventViewModel

    lateinit var rvListEvent: RecyclerView

    lateinit var eventAdapter: EventAdapter

    var observer = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FavoriteActivityUI().setContentView(this)

        supportActionBar?.title = "Favorites"

    }

    override fun onResume() {
        super.onResume()
        var team = TeamDummy().getDummyTeams()
        val sectionsPagerAdapter =
            FavoriteSectionsPagerAdapter(
                this,
                supportFragmentManager,
                team
            )
        val viewPager: ViewPager = this.findViewById(R.id.favorite_view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = this.findViewById(R.id.favorite_tabs)
        tabs.setupWithViewPager(viewPager)
    }
}
