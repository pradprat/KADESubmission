package com.prads.kadesubmission.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.prads.kadesubmission.R
import com.prads.kadesubmission.TeamFragment
import com.prads.kadesubmission.data.model.LeagueLocal
import com.prads.kadesubmission.ui.EventFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(
    private val context: Context,
    fm: FragmentManager,
    private val league: LeagueLocal
) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a EventFragment (defined as a static inner class below).
        return when (position) {
            2 -> {
                TeamFragment.newInstance(league)
            }
            else -> {
                EventFragment.newInstance(
                    position + 1,
                    league
                )
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 3
    }
}