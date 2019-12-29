package com.prads.kadesubmission.ui.layout

import com.prads.kadesubmission.ui.FavoriteEventActivity
import com.prads.kadesubmission.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class FavoriteEventActivityUI : AnkoComponent<FavoriteEventActivity> {
    override fun createView(ui: AnkoContext<FavoriteEventActivity>) = with(ui) {
        linearLayout {
            //tools:context = .SearchEventActivity //not support attribute
            recyclerView {
                id = R.id.rv_list_favorite_events
            }.lparams(width = matchParent, height = matchParent)
        }
    }
}