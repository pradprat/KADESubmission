package com.prads.kadesubmission.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.prads.kadesubmission.R
import com.prads.kadesubmission.data.model.Team
import com.prads.kadesubmission.ui.TeamDetailFragment
import com.prads.kadesubmission.ui.TeamEventFragment

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
    private val team: Team
) : FragmentPagerAdapter(fm) {

    override fun getItemPosition(`object`: Any): Int {
        return super.getItemPosition(`object`)
    }

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a EventFragment (defined as a static inner class below).
        return when (position) {
            0 -> {
                TeamDetailFragment.newInstance(team)
            }
            else -> {
                TeamEventFragment.newInstance(team)
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

