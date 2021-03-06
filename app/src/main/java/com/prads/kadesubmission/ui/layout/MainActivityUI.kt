package com.prads.kadesubmission.ui.layout

import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.RecyclerView
import com.prads.kadesubmission.R
import com.prads.kadesubmission.ui.MainActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivityUI : AnkoComponent<MainActivity> {
    lateinit var rvLeague: RecyclerView
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout{
            background = ColorDrawable(resources.getColor(R.color.colorPrimary))
            rvLeague = recyclerView {
                id = R.id.rv_list_league
                lparams(width = matchParent, height =  matchParent)
            }
        }
    }
}