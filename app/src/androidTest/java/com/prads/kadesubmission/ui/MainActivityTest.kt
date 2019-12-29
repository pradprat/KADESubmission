package com.prads.kadesubmission.ui

import RecyclerViewItemCountAssertion
import android.widget.EditText
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.pressImeActionButton
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.prads.kadesubmission.R
import com.prads.kadesubmission.ui.adapter.LeagueAdapter
import com.prads.kadesubmission.utils.EspressoIdlingResource
import junit.framework.AssertionFailedError
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MainActivityTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource)

        activityTestRule.activity
            .fragmentManager.beginTransaction()
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource)
    }


    @Test
    fun SearchEventTest() {
//        buka aplikasi
//        memastikan aplikasi menampilkan recyclerview untuk league
//        memastikan aplikasi menampilkan list league berjumlah 10
//        klik league index ke-0 di list league
//        memastikan aplikasi menampilkan icon pencarian
//        klik icon pencarian
//        ketik "chelsea" dan tekan enter
//        memastikan aplikasi menampilkan recyclerview untuk list events
//        klik league index ke-0 di list events
//        memastikan aplikasi menampilkan pertandingan "chelsea" pada team home atau away

        Espresso.onView(ViewMatchers.withId(R.id.rv_list_league))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.rv_list_league))
            .check((RecyclerViewItemCountAssertion(10)))

        Espresso.onView(ViewMatchers.withId(R.id.rv_list_league)).perform(
            RecyclerViewActions.actionOnItemAtPosition<LeagueAdapter.LeagueViewHolder>(
                0,
                ViewActions.click()
            )
        )

        Espresso.onView(ViewMatchers.withId(R.id.league_detail_search))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.league_detail_search)).perform(ViewActions.click())

        Espresso.onView(isAssignableFrom(EditText::class.java))
            .perform(typeText("chelsea"), pressImeActionButton())

        Espresso.onView(ViewMatchers.withId(R.id.rv_list_search_events))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.rv_list_search_events)).perform(
            RecyclerViewActions.actionOnItemAtPosition<LeagueAdapter.LeagueViewHolder>(
                0,
                ViewActions.click()
            )
        )

        try {
            Espresso.onView(ViewMatchers.withId(R.id.event_detail_home_name)).check(
                ViewAssertions.matches(
                    withText("Chelsea")
                )
            )
        } catch (e: AssertionFailedError) {
            Espresso.onView(ViewMatchers.withId(R.id.event_detail_away_name)).check(
                ViewAssertions.matches(
                    withText("Chelsea")
                )
            )
        }
    }


}