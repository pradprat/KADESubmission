package com.prads.kadesubmission.ui.layout

import com.prads.kadesubmission.R
import com.prads.kadesubmission.ui.SearchEventActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class SearchEventActivityUI : AnkoComponent<SearchEventActivity> {
    override fun createView(ui: AnkoContext<SearchEventActivity>) = with(ui) {
        linearLayout {
            //tools:context = .SearchEventActivity //not support attribute
            recyclerView {
                id = R.id.rv_list_search_events
            }.lparams(width = matchParent, height = matchParent)
        }
    }
}