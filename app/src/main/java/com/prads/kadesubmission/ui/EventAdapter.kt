package com.prads.kadesubmission.ui

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.Event
import com.prads.kadesubmission.ui.EventAdapter.ViewHolder
import com.prads.kadesubmission.ui.layout.EventItemUI
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class EventAdapter (private val listener: (Event) -> (Unit)):
    RecyclerView.Adapter<ViewHolder>() {

    private val events = mutableListOf<Event>()

    fun addData(teams:List<Event>){
        teams.let{
            this.events.addAll(it)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            EventItemUI().createView(
                AnkoContext.create(parent.context, parent)
            )
        )
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(events[position], listener)
    }

    inner class ViewHolder(override val containerView: View):LayoutContainer, RecyclerView.ViewHolder(containerView) {
        private  val item_event_date: TextView = containerView.find(id = R.id.item_event_date)
        private  val item_event_time: TextView = containerView.find(id = R.id.item_event_time)
        private  val event_divider: TextView = containerView.find(id = R.id.event_divider)
        private  val item_score_home: TextView = containerView.find(id = R.id.item_score_home)
        private  val item_score_away: TextView = containerView.find(id = R.id.item_score_away)
        private  val item_event_logo_home: ImageView = containerView.find(id = R.id.item_event_logo_home)
        private  val item_event_name_home: TextView = containerView.find(id = R.id.item_event_name_home)
        private  val item_event_logo_away: ImageView = containerView.find(id = R.id.item_event_logo_away)
        private  val item_event_name_away: TextView = containerView.find(id = R.id.item_event_name_away)

        fun bindItem(item: Event, listener: (Event) -> Unit) {
            if (item.teamHome.strTeamBadge!=null){
                Glide.with(itemView.context)
                    .load(item.teamHome.strTeamBadge)
                    .into(item_event_logo_home)
            }
            if (item.teamHome.strTeamBadge!=null){
            Glide.with(itemView.context)
                .load(item.teamAway.strTeamBadge)
                .into(item_event_logo_away)
            }
            item_event_date.text = item.dateEvent
            item_event_time.text = item.strTime
            item_score_home.text = item.intHomeScore
            item_score_away.text = item.intAwayScore
            item_event_name_home.text = item.strHomeTeam
            item_event_name_away.text = item.strAwayTeam

            containerView.findViewById<CardView>(R.id.item_event_card).setOnClickListener {
                listener(item)
            }

        }

    }
}