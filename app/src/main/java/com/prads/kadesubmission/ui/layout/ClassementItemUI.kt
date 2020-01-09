package com.prads.kadesubmission.ui.layout

import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.prads.kadesubmission.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.constraint.layout.constraintLayout

//    Kita akan membuat layoutnya item di dalam adapter, menggunakan anko
class ClassementItemUI : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent)
                orientation = LinearLayout.VERTICAL
                cardView {
                    elevation = dip(4).toFloat()
                    radius = dip(8).toFloat()
                    //app:cardCornerRadius = 8dp //not support attribute
                    constraintLayout {
                        imageView {
                            id = R.id.iv_classement_item_logo
//                        setImageResource(R.drawable.english_league_1)
                        }.lparams(width = dip(40), height = dip(40)) {
                            margin = dip(4)
                            bottomToBottom =
                                ConstraintLayout.LayoutParams.PARENT_ID //not support attribute
                            startToStart =
                                ConstraintLayout.LayoutParams.PARENT_ID //not support attribute
                            topToTop =
                                ConstraintLayout.LayoutParams.PARENT_ID //not support attribute
                        }
                        textView {
                            id = R.id.tv_classement_item_team
                            text = "Team"
                            textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                            setTypeface(typeface, Typeface.BOLD)
                        }.lparams(width = 0) {
                            bottomToBottom =
                                ConstraintLayout.LayoutParams.PARENT_ID //not support attribute
                            endToStart = R.id.tv_classement_item_win //not support attribute
                            startToEnd = R.id.iv_classement_item_logo //not support attribute
                            topToTop =
                                ConstraintLayout.LayoutParams.PARENT_ID //not support attribute
                            margin = dip(8)
                        }
                        textView {
                            id = R.id.tv_classement_item_win
                            text = "Win"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                            setTypeface(typeface, Typeface.BOLD)
                        }.lparams(width = dip(40)) {
                            bottomToBottom =
                                ConstraintLayout.LayoutParams.PARENT_ID //not support attribute
                            endToStart = R.id.tv_classement_item_draw //not support attribute
                            topToTop =
                                ConstraintLayout.LayoutParams.PARENT_ID //not support attribute
                            margin = dip(8)
                        }
                        textView {
                            id = R.id.tv_classement_item_draw
                            text = "Draw"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                            setTypeface(typeface, Typeface.BOLD)
                        }.lparams(width = dip(37)) {
                            bottomToBottom =
                                ConstraintLayout.LayoutParams.PARENT_ID //not support attribute
                            endToStart = R.id.tv_classement_item_loss //not support attribute
                            topToTop =
                                ConstraintLayout.LayoutParams.PARENT_ID //not support attribute
                            margin = dip(8)
                        }
                        textView {
                            id = R.id.tv_classement_item_loss
                            text = "Loss"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                            setTypeface(typeface, Typeface.BOLD)
                        }.lparams(width = dip(40)) {
                            bottomToBottom =
                                ConstraintLayout.LayoutParams.PARENT_ID //not support attribute
                            endToStart = R.id.tv_classement_item_total //not support attribute
                            topToTop =
                                ConstraintLayout.LayoutParams.PARENT_ID //not support attribute
                            margin = dip(8)
                        }
                        textView {
                            id = R.id.tv_classement_item_total
                            text = "Total"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                            setTypeface(typeface, Typeface.BOLD)
                        }.lparams(width = dip(40)) {
                            bottomToBottom =
                                ConstraintLayout.LayoutParams.PARENT_ID //not support attribute
                            endToEnd =
                                ConstraintLayout.LayoutParams.PARENT_ID //not support attribute
                            topToTop =
                                ConstraintLayout.LayoutParams.PARENT_ID //not support attribute
                            margin = dip(8)
                        }
                    }.lparams(width = matchParent)
                }.lparams(width = matchParent) {
                    margin = dip(4)
                }
            }
        }
    }
}