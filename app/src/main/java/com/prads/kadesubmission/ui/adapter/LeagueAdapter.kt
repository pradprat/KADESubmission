package com.prads.kadesubmission.ui.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.model.LeagueDummy
import com.prads.kadesubmission.ui.layout.LeagueItemUI
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class LeagueAdapter (private val listener: (LeagueDummy) -> Unit) : RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>(){

    private val leagues = mutableListOf<LeagueDummy>()

    fun addData(leagueDummies:List<LeagueDummy>){
        leagueDummies.let{
            this.leagues.addAll(it)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        return LeagueViewHolder(
            LeagueItemUI().createView(
                AnkoContext.create(parent.context, parent)
            )
        )
    }
    override fun getItemCount(): Int = leagues.size
    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(leagues[position], listener)
    }

    class LeagueViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        private  val leagueLogo: ImageView = containerView.find(R.id.item_league_logo)
        private  val leagueLogoDetail: ImageView = containerView.find(R.id.item_league_logo)

        fun bindItem(item: LeagueDummy, listener: (LeagueDummy) -> Unit) {

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
