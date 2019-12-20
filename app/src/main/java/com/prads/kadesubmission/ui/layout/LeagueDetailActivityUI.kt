package com.prads.kadesubmission.ui.layout

import android.view.Gravity
import android.view.View
import android.widget.ImageView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.internal.ForegroundLinearLayout
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
                    imageView {
                        id = R.id.title
                        padding = dip(16)
                        imageResource = R.drawable.american_mayor_league
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams(){
                        height = dip(100)
                        width = dip(100)
                        gravity = Gravity.CENTER
                    }
                    textView {
                        id = R.id.title
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        padding = dip(16)
                        text = "Description Description Description Description Description Description Description Description Description "
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