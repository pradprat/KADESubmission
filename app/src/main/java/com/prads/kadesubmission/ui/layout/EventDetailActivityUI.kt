package com.prads.kadesubmission.ui.layout

import android.icu.lang.UCharacter
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.internal.ForegroundLinearLayout
import com.prads.kadesubmission.R
import com.prads.kadesubmission.ui.EventDetailActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.design.*
import org.jetbrains.anko.support.v4.nestedScrollView
import org.jetbrains.anko.support.v4.viewPager

class EventDetailActivityUI : AnkoComponent<EventDetailActivity> {

    lateinit var ivToolbar : ImageView
    override fun createView(ui: AnkoContext<EventDetailActivity>): View {
        return with(ui){
            coordinatorLayout {
                themedAppBarLayout(R.style.AppTheme_AppBarOverlay) {
                    constraintLayout {
                        imageView {
                            id = R.id.event_detail_home_logo
                            imageResource = R.drawable.american_mayor_league
                        }.lparams(width = dimen(R.dimen.width_team_logo), height = dimen(R.dimen.width_team_logo)) {
                            margin = dimen(R.dimen.score_margin)
                            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                            topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                        }
                        imageView {
                            id = R.id.event_detail_away_logo
                            imageResource = R.drawable.american_mayor_league
                        }.lparams(width = dimen(R.dimen.width_team_logo), height = dimen(R.dimen.width_team_logo)) {
                            margin = dimen(R.dimen.score_margin)
                            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                            topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                        }
                        textView {
                            id = R.id.event_detail_home_name
                            text = "Home Team"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                            textSize = 18f //sp
                        }.lparams(width = dimen(R.dimen.width_team_logo)) {
                            margin = dimen(R.dimen.activity_vertical_margin)
                            endToEnd = R.id.event_detail_home_logo
                            startToStart = R.id.event_detail_home_logo
                            topToBottom = R.id.event_detail_home_logo
                            bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                        }
                        textView {
                            id = R.id.event_detail_away_name
                            text = "away Team"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                            textSize = 18f //sp
                        }.lparams(width = dimen(R.dimen.width_team_logo)) {
                            margin = dimen(R.dimen.activity_vertical_margin)
                            endToEnd = R.id.event_detail_away_logo
                            startToStart = R.id.event_detail_away_logo
                            topToBottom = R.id.event_detail_away_logo
                            bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                        }
                        textView {
                            id = R.id.event_detail_divider
                            text = ":"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                            textSize = 25f //sp
                        }.lparams(){
                            bottomToBottom = R.id.event_detail_home_logo
                            endToStart = R.id.event_detail_away_logo
                            startToEnd = R.id.event_detail_home_logo
                            topToTop = R.id.event_detail_away_logo
                        }
                        textView {
                            id = R.id.event_detail_home_score
                            text = "1"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                            textSize = 25f //sp
                        }.lparams(){
                            bottomToBottom = R.id.event_detail_home_logo
                            endToStart = R.id.event_detail_divider //not
                            startToEnd = R.id.event_detail_home_logo //n
                            topToTop = R.id.event_detail_home_logo
                        }
                        textView {
                            id = R.id.event_detail_away_score
                            text = "2"
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                            textSize = 25f //sp
                        }.lparams(){
                            bottomToBottom = R.id.event_detail_away_logo
                            endToStart = R.id.event_detail_away_logo //n
                            startToEnd = R.id.event_detail_divider //not
                            topToTop = R.id.event_detail_away_logo
                        }
                    }
                }.lparams(width = matchParent)
            }
        }
    }
}