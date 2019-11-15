package com.prads.kadesubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.prads.kadesubmission.data.League
import com.prads.kadesubmission.data.League.Companion.LEAGUE_ID
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import javax.inject.Inject

class LeagueDetailActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: LeagueViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LeagueDetailActivityUI().setContentView(this)

        var league_id : Int = intent.getIntExtra(LEAGUE_ID,0)

        viewModel = ViewModelProviders.of(this,viewModelFactory).get(LeagueViewModel::class.java)

        viewModel.loadLeagues().observe(this, Observer {
            for (item in it){
                if (item.id == league_id){
                    Glide.with(this)
                        .load(item.logo)
                        .into(find<ImageView>(R.id.detail_league_logo))

                    find<TextView>(R.id.detail_league_name).text = item.name
                    find<TextView>(R.id.detail_league_description).text = item.description
                }
            }

        })


    }
}
