package com.prads.kadesubmission.ui.layout

import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.RecyclerView
import com.prads.kadesubmission.R
import com.prads.kadesubmission.SearchEventActivity
import com.prads.kadesubmission.ui.MainActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class SearchEventActivityUI : AnkoComponent<SearchEventActivity> {
    lateinit var rvLeague: RecyclerView
    var rvEvent: RecyclerView? = null
    override fun createView(ui: AnkoContext<SearchEventActivity>) = with(ui) {
        linearLayout() {
            rvEvent = recyclerView(){
                id = R.id.rv_list_search_events
            }.lparams(width = matchParent)
        }
    }
}