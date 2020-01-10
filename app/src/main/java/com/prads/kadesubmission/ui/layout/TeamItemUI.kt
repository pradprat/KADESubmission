package com.prads.kadesubmission.ui.layout

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.prads.kadesubmission.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

//    Kita akan membuat layoutnya item di dalam adapter, menggunakan anko
class TeamItemUI : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                orientation = LinearLayout.VERTICAL
                cardView {
                    id = R.id.item_team_card
                    elevation = dip(8).toFloat()
                    radius = dip(8).toFloat()
                    linearLayout {
                        orientation = LinearLayout.VERTICAL
                        imageView {
                            id = R.id.item_team_logo
//                            imageResource = R.drawable.spanish_la_liga
                        }.lparams(width = dip(70), height = dip(70)) {
                            gravity = Gravity.CENTER
                            topMargin = dip(8)
                        }
                        textView {
                            id = R.id.item_team_name
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
//                            text = "Team 1"
                        }.lparams(width = matchParent) {
                            margin = dip(8)
                        }
                    }.lparams(width = matchParent)
                }.lparams(width = matchParent) {
                    margin = dip(8)
                }
            }
        }
    }
}