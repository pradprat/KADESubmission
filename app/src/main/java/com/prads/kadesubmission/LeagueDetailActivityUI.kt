package com.prads.kadesubmission

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class LeagueDetailActivityUI : AnkoComponent<LeagueDetailActivity> {



    override fun createView(ui: AnkoContext<LeagueDetailActivity>): View {
        return with(ui){
            verticalLayout(){
                lparams(width = matchParent, height = wrapContent)
                scrollView {
                    verticalLayout(){
                        lparams(width = matchParent, height = wrapContent)
                        imageView {
                            id = R.id.detail_league_logo
                        }.lparams {
                            height = dip(75)
                            width = dip(75)
                            margin = dip(16)
                        }
                        textView {
                            id = R.id.detail_league_name
                            textSize = 16f
                        }.lparams {
                            margin = dip(16)
                        }
                        textView {
                            id = R.id.detail_league_description
                            textSize = 16f
                        }.lparams {
                            margin = dip(16)
                        }
                    }

                }
            }
        }
    }
}