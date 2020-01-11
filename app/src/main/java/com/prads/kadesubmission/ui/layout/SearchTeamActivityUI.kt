package com.prads.kadesubmission.ui.layout

import com.prads.kadesubmission.R
import com.prads.kadesubmission.ui.SearchTeamActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView

class SearchTeamActivityUI : AnkoComponent<SearchTeamActivity> {
    override fun createView(ui: AnkoContext<SearchTeamActivity>) = with(ui) {
        linearLayout {
            recyclerView {
                id = R.id.rv_list_search_teams
            }.lparams(width = matchParent, height = matchParent)
        }
    }
}