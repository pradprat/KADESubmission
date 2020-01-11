package com.prads.kadesubmission.di.modules

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
    internal abstract fun contributeSearchTeamActivity(): SearchTeamActivity

    @ContributesAndroidInjector
    internal abstract fun contributeFavoriteEventActivity(): FavoriteActivity

    @ContributesAndroidInjector
    internal abstract fun contributeClassementActivity(): ClassementActivity

    @ContributesAndroidInjector
    internal abstract fun contributeTeamDetailActivity(): TeamDetailActivity

    @ContributesAndroidInjector
    internal abstract fun contributeTeamFragment(): TeamFragment

    @ContributesAndroidInjector
    internal abstract fun contributeTeamEventFragment(): TeamEventFragment

    @ContributesAndroidInjector
    internal abstract fun contributeTeamDetailFragment(): TeamDetailFragment

    @ContributesAndroidInjector
    internal abstract fun contributeFavoriteEventFragment(): FavoriteEventFragment

    @ContributesAndroidInjector
    internal abstract fun contributeFavoriteTeamFragment(): FavoriteTeamFragment

}