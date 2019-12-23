package com.prads.kadesubmission.di.modules

import com.prads.kadesubmission.SearchEventActivity
import com.prads.kadesubmission.ui.EventDetailActivity
import com.prads.kadesubmission.ui.MainActivity
import com.prads.kadesubmission.ui.LeagueDetailActivity
import com.prads.kadesubmission.ui.EventFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributeLeagueDetailActivity(): LeagueDetailActivity

    @ContributesAndroidInjector
    internal abstract fun contributeEventFragment(): EventFragment

    @ContributesAndroidInjector
    internal abstract fun contributeEventDetailActivity(): EventDetailActivity

    @ContributesAndroidInjector
    internal abstract fun contributeSearchEventActivity(): SearchEventActivity

}