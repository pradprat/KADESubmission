package com.prads.kadesubmission

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

//    Kita akan membuat layoutnya item di dalam adapter, menggunakan anko
class LeagueItemUI : AnkoComponent<ViewGroup> {

    lateinit var itemCardLeague:CardView
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            verticalLayout(){
                lparams(width = matchParent, height = wrapContent)
                paddingHorizontal = dip(8)
                paddingVertical = dip(4)
                orientation = LinearLayout.HORIZONTAL
                itemCardLeague=cardView {
                    id = R.id.item_league_card
                    verticalLayout(){
                        imageView {
                            id = R.id.item_league_logo
                        }.lparams {
                            height = dip(75)
                            width = dip(75)
                            margin = dip(16)
                        }

                        textView {
                            id = R.id.item_league_name
                            textSize = 16f
                        }.lparams {
                            margin = dip(16)
                        }
                    }
                }.lparams(){
                    width = matchParent
                    height = wrapContent
                    verticalMargin = dip(2)
                    horizontalMargin = dip(2)
                }
            }
        }
    }
}