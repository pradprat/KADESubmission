package com.prads.kadesubmission.di.modules

import com.prads.kadesubmission.ClassementActivity
import com.prads.kadesubmission.TeamFragment
import com.prads.kadesubmission.ui.*
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

    @ContributesAndroidInjector
    internal abstract fun contributeFavoriteEventActivity(): FavoriteEventActivity

    @ContributesAndroidInjector
    internal abstract fun contributeClassementActivity(): ClassementActivity

    @ContributesAndroidInjector
    internal abstract fun contributeTeamFragment(): TeamFragment

}