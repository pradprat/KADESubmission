package com.prads.kadesubmission.ui.layout

import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.prads.kadesubmission.ClassementActivity
import com.prads.kadesubmission.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.recyclerview.v7.recyclerView

class ClassementActivityUI : AnkoComponent<ClassementActivity> {
    lateinit var rvClassement: RecyclerView
    override fun createView(ui: AnkoContext<ClassementActivity>) = with(ui) {
        linearLayout {
            orientation = LinearLayout.VERTICAL
            cardView {
                elevation = dip(8).toFloat()
                //app:cardCornerRadius = 8dp //not support attribute
                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    imageView().lparams(width = dip(40), height = dip(40)) {
                        gravity = Gravity.CENTER
                        margin = dip(4)
                    }
                    textView {
                        text = "Team"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        setTypeface(typeface, Typeface.BOLD)
                    }.lparams(width = dip(100)) {
                        margin = dip(8)
                        gravity = Gravity.CENTER
                    }
                    textView {
                        text = "Win"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        setTypeface(typeface, Typeface.BOLD)
                    }.lparams(width = dip(40)) {
                        margin = dip(8)
                        gravity = Gravity.CENTER
                    }
                    textView {
                        text = "Draw"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        setTypeface(typeface, Typeface.BOLD)
                    }.lparams(width = dip(40)) {
                        margin = dip(8)
                        gravity = Gravity.CENTER
                    }
                    textView {
                        text = "Loss"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        setTypeface(typeface, Typeface.BOLD)
                    }.lparams(width = dip(40)) {
                        margin = dip(8)
                        gravity = Gravity.CENTER
                    }
                    textView {
                        text = "Total"
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        setTypeface(typeface, Typeface.BOLD)
                    }.lparams(width = dip(40)) {
                        margin = dip(8)
                        gravity = Gravity.CENTER
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