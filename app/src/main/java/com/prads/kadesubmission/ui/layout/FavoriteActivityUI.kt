package com.prads.kadesubmission.ui.layout

import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
import com.prads.kadesubmission.R
import com.prads.kadesubmission.ui.FavoriteActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.design.collapsingToolbarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.tabLayout
import org.jetbrains.anko.design.themedAppBarLayout
import org.jetbrains.anko.support.v4.viewPager

class FavoriteActivityUI : AnkoComponent<FavoriteActivity> {
    override fun createView(ui: AnkoContext<FavoriteActivity>) = with(ui) {
        coordinatorLayout {

            themedAppBarLayout(R.style.AppTheme_AppBarOverlay) {
                collapsingToolbarLayout {
                    tabLayout {
                        id = R.id.favorite_tabs
                        backgroundColor = colorAttr(R.attr.colorPrimary)
                    }.lparams(width = matchParent) {
                    }
                }.lparams(width = matchParent) {
                    scrollFlags = SCROLL_FLAG_ENTER_ALWAYS
                }

            }.lparams(width = matchParent)
            viewPager {
                id = R.id.favorite_view_pager
            }.lparams(width = matchParent, height = wrapContent) {
                behavior =
                    Class.forName(resources.getString(R.string.appbar_scrolling_view_behavior)).newInstance() as CoordinatorLayout.Behavior<*>?
            }
        }
    }
}