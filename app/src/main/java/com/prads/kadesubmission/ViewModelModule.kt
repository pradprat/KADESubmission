package com.prads.kadesubmission

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prads.kadesubmission.utils.DummyData
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {

    @Provides
    @IntoMap
    @ViewModelKey(LeagueViewModel::class)
    fun provideTvShowViewModel(LeagueRepository: LeagueRepository): ViewModel = LeagueViewModel(LeagueRepository)

    @Provides
    fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory =
        viewModelFactory
}