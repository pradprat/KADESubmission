package com.prads.kadesubmission.ui.layout

import android.graphics.Typeface
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
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.design.*
import org.jetbrains.anko.support.v4.nestedScrollView
import org.jetbrains.anko.support.v4.viewPager

class EventDetailActivityUI : AnkoComponent<EventDetailActivity> {

    lateinit var ivToolbar : ImageView
    override fun createView(ui: AnkoContext<EventDetailActivity>): View {
        return with(ui){
            scrollView() {
                linearLayout(){
                    orientation = LinearLayout.VERTICAL
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
                    constraintLayout {
                        textView {
                            id = R.id.tv_event_detail_date
                            text = "12-30-2019"
                            textSize = 20f //sp
                        }.lparams {
                            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                            topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                            topMargin = dip(8)
                        }
                        textView {
                            id = R.id.tv_event_detail_time
                            text = "20:11:00"
                        }.lparams {
                            endToEnd = R.id.tv_event_detail_date
                            startToStart = R.id.tv_event_detail_date
                            topToBottom = R.id.tv_event_detail_date
                            topMargin = dip(8)
                        }
                        cardView {
                            id = R.id.card_event_detail_formation
                            padding = dip(8)
                            constraintLayout {
                                textView {
                                    id = R.id.tv_event_detail_formation_label
                                    text = "Formation"
                                    setTypeface(typeface, Typeface.BOLD)
                                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                                }.lparams {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                                textView {
                                    id = R.id.tv_event_detail_formation_home
                                    text = "4-3-2"
                                    textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToStart = R.id.tv_event_detail_formation_label
                                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                                textView {
                                    id = R.id.tv_event_detail_formation_away
                                    text = "4-3-1"
                                    textAlignment = View.TEXT_ALIGNMENT_VIEW_END
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                                    startToEnd = R.id.tv_event_detail_formation_label
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                            }.lparams(width = matchParent)
                        }.lparams(width = matchParent) {
                            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                            topToBottom = R.id.tv_event_detail_time
                            margin = dip(8)
                        }
                        cardView {
                            id = R.id.card_event_detail_goals
                            padding = dip(8)
                            constraintLayout {
                                textView {
                                    id = R.id.tv_event_detail_goals_label
                                    text = "Goals"
                                    setTypeface(typeface, Typeface.BOLD)
                                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                                textView {
                                    id = R.id.tv_event_detail_goals_home
                                    textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                                    text = "69':Own  Jonjo Shelvey\n61': Adam Lallana\n51': Adam Lallana\n33': Alberto Moreno;"
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToStart = R.id.tv_event_detail_goals_label
                                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                                textView {
                                    id = R.id.tv_event_detail_goals_away
                                    textAlignment = View.TEXT_ALIGNMENT_VIEW_END
                                    text = "61': Adam Lallana\n51': Adam Lallana\n33': Alberto Moreno;"
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                                    startToEnd = R.id.tv_event_detail_goals_label
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                            }.lparams(width = matchParent)
                        }.lparams(width = matchParent) {
                            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                            topToBottom = R.id.card_event_detail_formation
                            margin = dip(8)
                        }
                        cardView {
                            id = R.id.card_event_detail_yellow
                            padding = dip(8)
                            constraintLayout {
                                textView {
                                    id = R.id.tv_event_detail_yellow_label
                                    text = "Yellow\nCards"
                                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                                    setTypeface(typeface, Typeface.BOLD)
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                                textView {
                                    id = R.id.tv_event_detail_yellow_home
                                    text = "49': Martin Skrtel;"
                                    textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToStart = R.id.tv_event_detail_yellow_label
                                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                                textView {
                                    id = R.id.tv_event_detail_yellow_away
                                    text = "61': Adam Lallana\n51': Adam Lallana\n"
                                    textAlignment = View.TEXT_ALIGNMENT_VIEW_END
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                                    startToEnd = R.id.tv_event_detail_yellow_label
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                            }.lparams(width = matchParent)
                        }.lparams(width = matchParent) {
                            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                            topToBottom = R.id.card_event_detail_goals
                            margin = dip(8)
                        }
                        cardView {
                            id = R.id.card_event_detail_red
                            padding = dip(8)
                            constraintLayout {
                                textView {
                                    id = R.id.tv_event_detail_red_label
                                    text = "Red\nCards"
                                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                                    setTypeface(typeface, Typeface.BOLD)
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                                textView {
                                    id = R.id.tv_event_detail_red_home
                                    text = "49': Martin Skrtel;"
                                    textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToStart = R.id.tv_event_detail_red_label
                                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                                textView {
                                    id = R.id.tv_event_detail_red_away
                                    text = "61': Adam Lallana\n51': Adam Lallana\n"
                                    textAlignment = View.TEXT_ALIGNMENT_VIEW_END
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                                    startToEnd = R.id.tv_event_detail_red_label
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                            }.lparams(width = matchParent)
                        }.lparams(width = matchParent) {
                            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                            topToBottom = R.id.card_event_detail_yellow
                            margin = dip(8)
                        }
                        cardView {
                            id = R.id.card_event_detail_keeper
                            padding = dip(8)
                            constraintLayout {
                                textView {
                                    id = R.id.tv_event_detail_keeper_label
                                    text = "Goal Keeper"
                                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                                    setTypeface(typeface, Typeface.BOLD)
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                                textView {
                                    id = R.id.tv_event_detail_keeper_home
                                    text = "49': Martin Skrtel;"
                                    textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToStart = R.id.tv_event_detail_keeper_label
                                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                                textView {
                                    id = R.id.tv_event_detail_keeper_away
                                    text = "61': Adam Lallana\n51': Adam Lallana\n"
                                    textAlignment = View.TEXT_ALIGNMENT_VIEW_END
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                                    startToEnd = R.id.tv_event_detail_keeper_label
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                            }.lparams(width = matchParent)
                        }.lparams(width = matchParent) {
                            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                            topToBottom = R.id.card_event_detail_red
                            margin = dip(8)
                        }
                        cardView {
                            id = R.id.card_event_detail_defenses
                            padding = dip(8)
                            constraintLayout {
                                textView {
                                    id = R.id.tv_event_detail_defenses_label
                                    text = "Defenses"
                                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                                    setTypeface(typeface, Typeface.BOLD)
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                                textView {
                                    id = R.id.tv_event_detail_defenses_home
                                    text = "49': Martin Skrtel;"
                                    textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToStart = R.id.tv_event_detail_defenses_label
                                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                                textView {
                                    id = R.id.tv_event_detail_defenses_away
                                    text = "61': Adam Lallana\n51': Adam Lallana\n"
                                    textAlignment = View.TEXT_ALIGNMENT_VIEW_END
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                                    startToEnd = R.id.tv_event_detail_defenses_label
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                            }.lparams(width = matchParent)
                        }.lparams(width = matchParent) {
                            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                            topToBottom = R.id.card_event_detail_keeper
                            margin = dip(8)
                        }
                        cardView {
                            id = R.id.card_event_detail_mid
                            padding = dip(8)
                            constraintLayout {
                                textView {
                                    id = R.id.tv_event_detail_mid_label
                                    text = "Mid Fields"
                                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                                    setTypeface(typeface, Typeface.BOLD)
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                                textView {
                                    id = R.id.tv_event_detail_mid_home
                                    text = "49': Martin Skrtel;"
                                    textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToStart = R.id.tv_event_detail_mid_label
                                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                                textView {
                                    id = R.id.tv_event_detail_mid_away
                                    text = "61': Adam Lallana\n51': Adam Lallana\n"
                                    textAlignment = View.TEXT_ALIGNMENT_VIEW_END
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                                    startToEnd = R.id.tv_event_detail_mid_label
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                            }.lparams(width = matchParent)
                        }.lparams(width = matchParent) {
                            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                            topToBottom = R.id.card_event_detail_keeper
                            margin = dip(8)
                        }
                        cardView {
                            id = R.id.card_event_detail_forwards
                            padding = dip(8)
                            constraintLayout {
                                textView {
                                    id = R.id.tv_event_detail_forwards_label
                                    text = "Forwards"
                                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                                    setTypeface(typeface, Typeface.BOLD)
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                                textView {
                                    id = R.id.tv_event_detail_forwards_home
                                    text = "49': Martin Skrtel;"
                                    textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToStart = R.id.tv_event_detail_forwards_label
                                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                                textView {
                                    id = R.id.tv_event_detail_forwards_away
                                    text = "61': Adam Lallana\n51': Adam Lallana\n"
                                    textAlignment = View.TEXT_ALIGNMENT_VIEW_END
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                                    startToEnd = R.id.tv_event_detail_forwards_label
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                            }.lparams(width = matchParent)
                        }.lparams(width = matchParent) {
                            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                            topToBottom = R.id.card_event_detail_mid
                            margin = dip(8)
                        }
                        cardView {
                            id = R.id.card_event_detail_subst
                            padding = dip(8)
                            constraintLayout {
                                textView {
                                    id = R.id.tv_event_detail_subst_label
                                    text = "Substitutes"
                                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                                    setTypeface(typeface, Typeface.BOLD)
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                                textView {
                                    id = R.id.tv_event_detail_subst_home
                                    text = "49': Martin Skrtel;"
                                    textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToStart = R.id.tv_event_detail_subst_label
                                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                                textView {
                                    id = R.id.tv_event_detail_subst_away
                                    text = "61': Adam Lallana\n51': Adam Lallana\n"
                                    textAlignment = View.TEXT_ALIGNMENT_VIEW_END
                                }.lparams() {
                                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                                    startToEnd = R.id.tv_event_detail_subst_label
                                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                                    margin = dip(8)
                                }
                            }.lparams(width = matchParent)
                        }.lparams(width = matchParent) {
                            endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                            startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                            topToBottom = R.id.card_event_detail_forwards
                            bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                            margin = dip(8)
                        }
                    }
                }
            }
        }
    }
}