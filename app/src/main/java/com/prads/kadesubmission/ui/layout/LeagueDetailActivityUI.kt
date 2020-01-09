package com.prads.kadesubmission.ui.layout

import android.view.Gravity
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.prads.kadesubmission.R
import com.prads.kadesubmission.ui.LeagueDetailActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.tabLayout
import org.jetbrains.anko.design.themedAppBarLayout
import org.jetbrains.anko.support.v4.viewPager

class LeagueDetailActivityUI : AnkoComponent<LeagueDetailActivity> {

    override fun createView(ui: AnkoContext<LeagueDetailActivity>): View {
        return with(ui){
            coordinatorLayout {
                themedAppBarLayout(R.style.AppTheme_AppBarOverlay) {
                    imageView {
                        id = R.id.iv_league_detail_poster
                        padding = dip(16)
//                        imageResource = R.drawable.american_mayor_league
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams {
                        height = dip(100)
                        width = dip(100)
                        gravity = Gravity.CENTER
                    }
                    textView {
                        id = R.id.tv_league_detail_description
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        padding = dip(16)
                        text = ""
                    }
                    button("Klasemen") {
                        id = R.id.btn_league_detail_classement
                    }.lparams(width = matchParent) {
                        horizontalMargin = dip(16)
                    }
                    tabLayout {
                        id = R.id.tabs
                        backgroundColor = colorAttr(R.attr.colorPrimary)
                    }.lparams(width = matchParent)
                }.lparams(width = matchParent)

                viewPager {
                    id = R.id.view_pager
                }.lparams(width = matchParent, height = wrapContent) {
                    behavior = Class.forName(resources.getString(R.string.appbar_scrolling_view_behavior)).newInstance() as CoordinatorLayout.Behavior<*>?
                }
            }
        }
    }
}