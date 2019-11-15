package com.prads.kadesubmission

import android.graphics.Movie
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
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
        private val leagueName: TextView = containerView.find(R.id.item_league_name)

        fun bindItem(item: League, listener: (League) -> Unit) {
            Glide.with(itemView.context)
                .load(item.logo)
                .into(leagueLogo)

            leagueName.text = item.name

//            containerView.movieCardContainer.setOnClickListener {
//                listener(item)
//            }
//            containerView.movieImage.apply {
//                Glide.with(itemView).load("$IMAGE_URL${item.moviePoster}").into(this)
//            }
//            containerView.movieTextTitle.text = item.movieTitle
//            containerView.movieTextOverview.text = item.movieOverview
//            containerView.movieTextReleaseDate.text = item.movieReleaseDate
        }


    }


}