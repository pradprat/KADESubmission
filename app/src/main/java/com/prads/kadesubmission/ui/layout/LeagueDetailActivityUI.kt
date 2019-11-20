package com.prads.kadesubmission.ui.layout

import android.view.Gravity
import android.view.View
import android.widget.ImageView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.prads.kadesubmission.R
import com.prads.kadesubmission.ui.tabs.LeagueDetailActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.design.*
import org.jetbrains.anko.support.v4.viewPager

class LeagueDetailActivityUI : AnkoComponent<LeagueDetailActivity> {

    lateinit var ivToolbar : ImageView


    override fun createView(ui: AnkoContext<LeagueDetailActivity>): View {
        return with(ui){
            coordinatorLayout {
                //tools:context = .ui.tabs.LeagueDetailActivity //not support attribute
                themedAppBarLayout(R.style.AppTheme_AppBarOverlay) {
                    textView {
                        id = R.id.title
                        gravity = Gravity.CENTER
                        minimumHeight = dimenAttr(R.attr.actionBarSize)
                        padding = R.dimen.appbar_padding
                        text = resources.getString(R.string.app_name)
                        textAppearance = R.style.TextAppearance_AppCompat_Title
                    }
                    tabLayout {
                        id = R.id.tabs
                        backgroundColor = colorAttr(R.attr.colorPrimary)
                    }.lparams(width = matchParent)
                }.lparams(width = matchParent)
                viewPager {
                    id = R.id.view_pager
                }.lparams(width = matchParent, height = matchParent) {
                    behavior = Class.forName(resources.getString(R.string.appbar_scrolling_view_behavior)).newInstance() as CoordinatorLayout.Behavior<*>?
                }
            }
        }
    }
}