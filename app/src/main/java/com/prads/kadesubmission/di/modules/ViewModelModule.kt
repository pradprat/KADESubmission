package com.prads.kadesubmission.di.modules

import androidx.lifecycle.ViewModel
import com.prads.kadesubmission.data.LeagueRepository
import com.prads.kadesubmission.data.EventRepository
import com.prads.kadesubmission.ui.LeagueViewModel
import com.prads.kadesubmission.di.ViewModelKey
import com.prads.kadesubmission.ui.tabs.EventViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
object ViewModelModule {
    @Provides
    @IntoMap
    @ViewModelKey(LeagueViewModel::class)
    fun provideLeagueViewModel(LeagueRepository: LeagueRepository): ViewModel =
        LeagueViewModel(LeagueRepository)

    @Provides
    @IntoMap
    @ViewModelKey(EventViewModel::class)
    fun provideEventViewModel(eventRepository: EventRepository): ViewModel =
        EventViewModel(eventRepository)
}