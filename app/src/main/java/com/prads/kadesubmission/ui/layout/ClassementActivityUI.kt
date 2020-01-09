package com.prads.kadesubmission.ui.layout

import android.graphics.Typeface
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
import androidx.recyclerview.widget.RecyclerView
import com.prads.kadesubmission.R
import com.prads.kadesubmission.ui.ClassementActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

class ClassementActivityUI : AnkoComponent<ClassementActivity> {
    lateinit var rvClassement: RecyclerView
    override fun createView(ui: AnkoContext<ClassementActivity>) = with(ui) {
        linearLayout {
            orientation = LinearLayout.VERTICAL
            cardView {
                elevation = dip(8).toFloat()
                radius = dip(8).toFloat()
                //app:cardCornerRadius = 8dp //not support attribute
                constraintLayout {
                    imageView {
                        id = R.id.iv_classement_logo
//                        setImageResource(R.drawable.english_league_1)
                    }.lparams(width = dip(40), height = dip(40)) {
                        margin = dip(4)
                        bottomToBottom = PARENT_ID //not support attribute
                        startToStart = PARENT_ID //not support attribute
                        topToTop = PARENT_ID //not support attribute
                    }
                    textView {
                        id = R.id.tv_classement_team
                        text = "Team"
                        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                        setTypeface(typeface, Typeface.BOLD)
                    }.lparams(width = 0) {
                        bottomToBottom = PARENT_ID //not support attribute
                        endToStart = R.id.tv_classement_win //not support attribute
                        startToEnd = R.id.iv_classement_logo //not support attribute
                        topToTop = PARENT_ID //not support attribute
                        margin = dip(8)
                    }
                    textView {
                        id = R.id.tv_classement_win
                        text = "Win"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        setTypeface(typeface, Typeface.BOLD)
                    }.lparams(width = dip(40)) {
                        bottomToBottom = PARENT_ID //not support attribute
                        endToStart = R.id.tv_classement_draw //not support attribute
                        topToTop = PARENT_ID //not support attribute
                        margin = dip(8)
                    }
                    textView {
                        id = R.id.tv_classement_draw
                        text = "Draw"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        setTypeface(typeface, Typeface.BOLD)
                    }.lparams(width = dip(37)) {
                        bottomToBottom = PARENT_ID //not support attribute
                        endToStart = R.id.tv_classement_loss //not support attribute
                        topToTop = PARENT_ID //not support attribute
                        margin = dip(8)
                    }
                    textView {
                        id = R.id.tv_classement_loss
                        text = "Loss"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        setTypeface(typeface, Typeface.BOLD)
                    }.lparams(width = dip(40)) {
                        bottomToBottom = PARENT_ID //not support attribute
                        endToStart = R.id.tv_classement_total //not support attribute
                        topToTop = PARENT_ID //not support attribute
                        margin = dip(8)
                    }
                    textView {
                        id = R.id.tv_classement_total
                        text = "Total"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        setTypeface(typeface, Typeface.BOLD)
                    }.lparams(width = dip(40)) {
                        bottomToBottom = PARENT_ID //not support attribute
                        endToEnd = PARENT_ID //not support attribute
                        topToTop = PARENT_ID //not support attribute
                        margin = dip(8)
                    }
                }.lparams(width = matchParent)
            }.lparams(width = matchParent) {
                margin = dip(8)
            }
            rvClassement = recyclerView {
                id = R.id.rv_list_classement
            }.lparams(width = matchParent)
        }
    }
}