package com.prads.kadesubmission

import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    internal fun getString(): String {
        return "from app module"
    }

}
