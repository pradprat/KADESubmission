package com.prads.kadesubmission

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

//    Kita akan membuat layoutnya item di dalam adapter, menggunakan anko
class LeagueItemUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            verticalLayout(){
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)
                orientation = LinearLayout.HORIZONTAL

                imageView {
                    id = R.id.item_league_logo
                }.lparams {
                    height = dip(75)
                    width = dip(75)
                }

                textView {
                    id = R.id.item_league_name
                    textSize = 16f
                }.lparams {
                    margin = dip(16)
                }

            }
        }
    }
}