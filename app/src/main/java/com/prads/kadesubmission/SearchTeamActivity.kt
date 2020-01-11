package com.prads.kadesubmission

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prads.kadesubmission.data.model.LeagueLocal
import com.prads.kadesubmission.ui.adapter.TeamAdapter
import com.prads.kadesubmission.ui.layout.SearchTeamActivityUI
import com.prads.kadesubmission.ui.viewmodel.TeamViewModel
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.setContentView
import javax.inject.Inject

class SearchTeamActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var teamViewModel: TeamViewModel

    lateinit var rvListTeams: RecyclerView

    lateinit var teamAdapter: TeamAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SearchTeamActivityUI().setContentView(this)

        val query = intent.getStringExtra("TAG_TEAM_SEARCH")
        val league = intent.getParcelableExtra<LeagueLocal>("TAG_LEAGUE_INFO")

        supportActionBar?.title = query

        teamAdapter = TeamAdapter {
            Intent(applicationContext, TeamDetailActivity::class.java).run {
                this.putExtra("TAG_TEAM", it)
                startActivity(this)
            }
        }

        teamViewModel = ViewModelProviders.of(this, viewModelFactory).get(TeamViewModel::class.java)

        teamViewModel.searchTeams(query, league.id).observe(this, Observer {
            teamAdapter.addData(it)
        })

        rvListTeams = findViewById(R.id.rv_list_search_teams)

        rvListTeams.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = teamAdapter
        }
    }
}
