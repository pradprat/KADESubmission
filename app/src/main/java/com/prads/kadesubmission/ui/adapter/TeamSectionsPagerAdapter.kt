package com.prads.kadesubmission.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.model.LeagueLocal
import com.prads.kadesubmission.ui.EventFragment
import com.prads.kadesubmission.ui.TeamDetailFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_team_1,
    R.string.tab_team_2
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class TeamSectionsPagerAdapter(
    private val context: Context,
    fm: FragmentManager,
    private val league: LeagueLocal
) : FragmentPagerAdapter(fm) {

    override fun getItemPosition(`object`: Any): Int {
        return super.getItemPosition(`object`)
    }

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a EventFragment (defined as a static inner class below).
        return when (position) {
            0 -> {
                TeamDetailFragment.newInstance()
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
        return 2
    }
}

