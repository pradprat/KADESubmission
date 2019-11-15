package com.prads.kadesubmission

import android.graphics.Movie
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prads.kadesubmission.data.League
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.*

class LeagueAdapter (private val listener: (League) -> Unit) : RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>(){

    private val leagues = mutableListOf<League>()

    fun addData(leagues:List<League>){
        leagues.let{
            this.leagues.addAll(it)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        return LeagueViewHolder(LeagueItemUI().createView(AnkoContext.create(parent.context, parent)))
    }
    override fun getItemCount(): Int = leagues.size
    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(leagues[position], listener)
    }

    class LeagueViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        private  val leagueLogo: ImageView = containerView.find(R.id.item_league_logo)
        private  val leagueLogoDetail: ImageView = containerView.find(R.id.item_league_logo)

        fun bindItem(item: League, listener: (League) -> Unit) {

            Glide.with(itemView.context)
                .load(item.logo)
                .into(leagueLogo)

            containerView.find<TextView>(R.id.item_league_name).text = item.name

            containerView.findViewById<CardView>(R.id.item_league_card).setOnClickListener {
                listener(item)
            }

        }


    }


}
