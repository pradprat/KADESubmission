package com.prads.kadesubmission.di.modules

import com.example.subm1jetpackmovieskuy.data.source.ApiMain
import com.example.subm1jetpackmovieskuy.data.source.ApiService
import dagger.Module
import dagger.Provides

@Module
object ApiModule{

    @Provides
    fun provideApiService(apiMain: ApiMain):ApiService = apiMain.services
}