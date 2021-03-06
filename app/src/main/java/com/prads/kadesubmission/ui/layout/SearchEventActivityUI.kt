package com.prads.kadesubmission.ui.layout

import com.prads.kadesubmission.R
import com.prads.kadesubmission.ui.SearchEventActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView

class SearchEventActivityUI : AnkoComponent<SearchEventActivity> {
    override fun createView(ui: AnkoContext<SearchEventActivity>) = with(ui) {
        linearLayout {
            recyclerView {
                id = R.id.rv_list_search_events
            }.lparams(width = matchParent, height = matchParent)
        }
    }
}