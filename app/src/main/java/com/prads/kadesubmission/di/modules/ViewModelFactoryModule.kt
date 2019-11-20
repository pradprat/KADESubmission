package com.prads.kadesubmission.di.modules

import androidx.lifecycle.ViewModelProvider
import com.prads.kadesubmission.di.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
object ViewModelFactoryModule {

    @Provides
    fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory =
        viewModelFactory
}