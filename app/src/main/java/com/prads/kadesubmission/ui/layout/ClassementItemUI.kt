package com.prads.kadesubmission.ui.layout

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.prads.kadesubmission.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

//    Kita akan membuat layoutnya item di dalam adapter, menggunakan anko
class ClassementItemUI : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                orientation = LinearLayout.VERTICAL
                cardView {
                    elevation = dip(8).toFloat()
                    linearLayout {
                        orientation = LinearLayout.HORIZONTAL
                        imageView {
                            imageResource = R.drawable.spanish_la_liga
                        }.lparams(width = dip(40), height = dip(40)) {
                            gravity = Gravity.CENTER
                            margin = dip(4)
                        }
                        textView {
                            text = "Team 1"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams(width = dip(100)) {
                            margin = dip(8)
                            gravity = Gravity.CENTER
                        }
                        textView {
                            text = "2"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams(width = dip(40)) {
                            margin = dip(8)
                            gravity = Gravity.CENTER
                        }
                        textView {
                            text = "2"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams(width = dip(40)) {
                            margin = dip(8)
                            gravity = Gravity.CENTER
                        }
                        textView {
                            text = "3"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams(width = dip(40)) {
                            margin = dip(8)
                            gravity = Gravity.CENTER
                        }
                        textView {
                            text = "15"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams(width = dip(40)) {
                            margin = dip(8)
                            gravity = Gravity.CENTER
                        }
                    }.lparams(width = matchParent)
                }.lparams(width = matchParent) {
                    margin = dip(8)
                }
            }
        }
    }
}