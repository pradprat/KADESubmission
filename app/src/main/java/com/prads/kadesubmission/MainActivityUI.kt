package com.prads.kadesubmission

import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.verticalLayout

class MainActivityUI : AnkoComponent<MainActivity> {
    lateinit var rvLeague: RecyclerView
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout{
            rvLeague = recyclerView {
                id = R.id.rv_list_league
                lparams(width = matchParent, height =  matchParent)
            }
        }
    }
}