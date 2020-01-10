package com.prads.kadesubmission.ui.layout

import android.view.Gravity
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.prads.kadesubmission.R
import com.prads.kadesubmission.TeamDetailActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.tabLayout
import org.jetbrains.anko.design.themedAppBarLayout
import org.jetbrains.anko.support.v4.viewPager

class TeamDetailActivityUI : AnkoComponent<TeamDetailActivity> {

    override fun createView(ui: AnkoContext<TeamDetailActivity>): View {
        return with(ui) {
            coordinatorLayout {
                themedAppBarLayout(R.style.AppTheme_AppBarOverlay) {
                    imageView {
                        id = R.id.iv_team_detail_poster
                        padding = dip(16)
//                        imageResource = R.drawable.american_mayor_league
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams {
                        height = dip(100)
                        width = dip(100)
                        gravity = Gravity.CENTER
                    }
                    textView {
                        id = R.id.tv_team_detail_description
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        padding = dip(16)
                        text = ""
                    }
                    tabLayout {
                        id = R.id.team_tabs
                        backgroundColor = colorAttr(R.attr.colorPrimary)
                    }.lparams(width = matchParent)
                }.lparams(width = matchParent)

                viewPager {
                    id = R.id.team_view_pager
                }.lparams(width = matchParent, height = wrapContent) {
                    behavior =
                        Class.forName(resources.getString(R.string.appbar_scrolling_view_behavior)).newInstance() as CoordinatorLayout.Behavior<*>?
                }
            }
        }
    }
}