package com.prads.kadesubmission.ui.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.model.Team
import com.prads.kadesubmission.ui.layout.TeamItemUI
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class TeamAdapter(private val listener: (Team) -> Unit) :
    RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    private val teams = mutableListOf<Team>()

    fun addData(Teams: List<Team>) {
        Teams.let {
            this.teams.addAll(it)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(
            TeamItemUI().createView(
                AnkoContext.create(parent.context, parent)
            )
        )
    }

    override fun getItemCount(): Int = teams.size
    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(teams[position], listener)
    }

    class TeamViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        private val teamLogo: ImageView = containerView.find(R.id.item_team_logo)

        fun bindItem(item: Team, listener: (Team) -> Unit) {

            Glide.with(itemView.context)
                .load(item.strTeamLogo)
                .into(teamLogo)

            containerView.find<TextView>(R.id.item_team_name).text = item.strTeam

            containerView.findViewById<CardView>(R.id.item_team_card).setOnClickListener {
                listener(item)
            }

        }


    }


}
