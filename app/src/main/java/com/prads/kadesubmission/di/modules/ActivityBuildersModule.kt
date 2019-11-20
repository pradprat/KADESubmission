package com.prads.kadesubmission.di.modules

import com.prads.kadesubmission.ui.MainActivity
import com.prads.kadesubmission.ui.tabs.LeagueDetailActivity
import com.prads.kadesubmission.ui.tabs.EventFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributeLeagueDetailActivity():LeagueDetailActivity

    @ContributesAndroidInjector
    internal abstract fun contributePlaceholderFragment(): EventFragment

}