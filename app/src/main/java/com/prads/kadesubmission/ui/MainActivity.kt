package com.prads.kadesubmission.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prads.kadesubmission.R
import com.prads.kadesubmission.ui.adapter.LeagueAdapter
import com.prads.kadesubmission.ui.layout.MainActivityUI
import com.prads.kadesubmission.ui.viewmodel.LeagueViewModel
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() , AnkoLogger{


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var leagueViewModel: LeagueViewModel

    lateinit var rvListLeague:RecyclerView

    lateinit var leagueAdapter: LeagueAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var mainUI = MainActivityUI()
        mainUI.setContentView(this)

        leagueViewModel = ViewModelProviders.of(this,viewModelFactory).get(LeagueViewModel::class.java)


        leagueViewModel.loadLeagues().observe(this, Observer {
            leagueAdapter.addData(it)
            info("data observed")
        })

        leagueAdapter = LeagueAdapter {
            Intent(this, LeagueDetailActivity::class.java).run {
                this.putExtra("TAG_LEAGUE", it)
                toast("kamu memilih " + it.name)
                startActivity(this)
            }
        }

        rvListLeague = mainUI.rvLeague

        rvListLeague.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = leagueAdapter
//            info("recyclerview created")
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.main_list_favorite){
            Intent(applicationContext, FavoriteActivity::class.java).run {
                startActivity(this)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}
