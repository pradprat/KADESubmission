package com.prads.kadesubmission.ui.layout

import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
import com.prads.kadesubmission.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.constraint.layout.constraintLayout

/**
 * Generate with Plugin
 * @plugin Kotlin Anko Converter For Xml
 * @version 1.3.4
 */
class EventItemUI : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                orientation = LinearLayout.VERTICAL
                cardView {
                    elevation = dip(4).toFloat()
                    radius = dip(8).toFloat()
                    lparams(width = matchParent, height = wrapContent){
                        margin = dip(8)
                    }
                    id = R.id.item_event_card
                    constraintLayout {
                        lparams(width = matchParent, height = wrapContent){
                            padding = dip(8)
                        }
                        textView {
                            id = R.id.item_event_date
                            text = "12 desember 2019"
                        }.lparams {
                            endToEnd = PARENT_ID //not support attribute
                            startToStart = PARENT_ID //not support attribute
                            topToTop = PARENT_ID //not support attribute
                        }
                        textView {
                            id = R.id.item_event_time
                            text = "19:10:10"
                        }.lparams {
                            endToEnd = R.id.item_event_date //not support attribute
                            startToStart = R.id.item_event_date //not support attribute
                            topToBottom = R.id.item_event_date //not support attribute
                        }
                        textView {
                            id = R.id.event_divider
                            text = ":"
                            textSize = sp(8).toFloat()
                        }.lparams {
                            bottomToBottom = PARENT_ID //not support attribute
                            endToEnd = R.id.item_event_time //not support attribute
                            startToStart = R.id.item_event_time //not support attribute
                            topToBottom = R.id.item_event_time //not support attribute
                            topMargin = dip(16)
                        }
                        textView {
                            id = R.id.item_score_home
                            text = "1"
                            textSize = sp(8).toFloat()
                        }.lparams {
                            bottomToBottom = R.id.event_divider //not support attribute
                            endToStart = R.id.event_divider //not support attribute
                            marginEnd = dip(8)
                            marginStart = dip(8)
                            topToTop = R.id.event_divider //not support attribute
                        }
                        textView {
                            id = R.id.item_score_away
                            text = "2"
                            textSize = sp(8).toFloat()
                        }.lparams {
                            bottomToBottom = R.id.event_divider //not support attribute
                            startToEnd = R.id.event_divider //not support attribute
                            marginStart = dip(8)
                            marginEnd = dip(8)
                            topToTop = R.id.event_divider //not support attribute
                        }
                        textView {
                            id = R.id.item_event_name_home
                            text = "portugal"
                            textSize = sp(6).toFloat()
                            typeface = Typeface.DEFAULT_BOLD
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams {
                            height = wrapContent
                            width = 0
                            bottomToBottom = R.id.item_score_home //not support attribute
                            endToStart = R.id.item_score_home //not support attribute
                            startToStart = PARENT_ID //not support attribute
                            topToTop = R.id.item_score_home //not support attribute
                        }
                        textView {
                            id = R.id.item_event_name_away
                            text = "England"
                            textSize = sp(6).toFloat()
                            typeface = Typeface.DEFAULT_BOLD
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams {
                            height = wrapContent
                            width = 0
                            bottomToBottom = R.id.item_score_away //not support attribute
                            endToEnd = PARENT_ID //not support attribute
                            startToEnd = R.id.item_score_away //not support attribute
                            topToTop = R.id.item_score_away //not support attribute
                        }
                    }
                }
            }
        }
    }
}
