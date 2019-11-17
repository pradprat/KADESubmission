package com.prads.kadesubmission

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.prads.kadesubmission.data.LeagueDummy
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class LeagueDetailActivity : DaggerAppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LeagueDetailActivityUI().setContentView(this)

        var item : LeagueDummy = intent.getParcelableExtra("TAG_LEAGUE")

        Glide.with(this)
            .load(item.logo)
            .into(find<ImageView>(R.id.detail_league_logo))

        find<TextView>(R.id.detail_league_name).text = item.name
        find<TextView>(R.id.detail_league_description).text = item.description


    }
}
