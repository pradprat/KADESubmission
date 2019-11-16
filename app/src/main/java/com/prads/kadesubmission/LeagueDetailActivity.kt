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
import com.prads.kadesubmission.data.League.CREATOR.TAG_LEAGUE
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import javax.inject.Inject

class LeagueDetailActivity : DaggerAppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LeagueDetailActivityUI().setContentView(this)

        var item : League = intent.getParcelableExtra(TAG_LEAGUE)

        Glide.with(this)
            .load(item.logo)
            .into(find<ImageView>(R.id.detail_league_logo))

        find<TextView>(R.id.detail_league_name).text = item.name
        find<TextView>(R.id.detail_league_description).text = item.description


    }
}
